package com.example.service.common;

import com.example.common.MailConfiguration;
import com.example.domain.common.Contact;
import com.example.form.common.ContactForm;
import com.example.mapper.common.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;


/**
 * 問合せをするサービスクラス.
 *
 */
@Service
@Transactional
public class ContactService {

    private final JavaMailSender javaMailSender;

    @Autowired
    ContactService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private MailConfiguration mailConfiguration;


    /**
     * 問合せ内容を登録するメソッド¥]
     *
     *
     * @param form フォーム
     */
    public void registerContact(ContactForm form){
        Contact contact = new Contact();
        contact.setName(form.getName());
        contact.setEmail(form.getEmail());
        contact.setContent(form.getContent());
        contact.setSendAt(LocalDateTime.now());
        contactMapper.insert(contact);
        sendMailHTML(contact);
    }

    /*
    *　メールメッセージをモデル化.
    *
     */
    public SimpleMailMessage sendMail(Contact contact){
        SimpleMailMessage mailMessage= new SimpleMailMessage();
        String from = mailConfiguration.getMailAddress();
        try{
            mailMessage.setTo(contact.getEmail());
            mailMessage.setBcc(from);
            mailMessage.setSubject("[tabee]お問い合わせを承りました");
            mailMessage.setText(contact.toString());

            javaMailSender.send(mailMessage);
            return mailMessage;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * メールを送信する.
     *
     * @param contact 問合せ内容
     */
    public void sendMailHTML(Contact contact){
        javaMailSender.send(new MimeMessagePreparator() {
            String from = mailConfiguration.getMailAddress();
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
                helper.setFrom(new InternetAddress(from,"tabee","utf-8"));
                helper.setTo(contact.getEmail());
                helper.setSubject("[tabee]お問い合わせを承りました");
                helper.setBcc(from);
                Context context = new Context();
                context.setVariable("contact",contact);
                helper.setText(getMailBody("mail",context), true);
            }
        });
    }

    /**
     * HTMLメールを作成する.
     *
     * @param templateName メールテンプレート名
     * @param context
     * @return
     */
    private String getMailBody(String templateName, Context context){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(mailTemplateResolver());
        return templateEngine.process(templateName, context);
    }

    /**
     * Resolverを設定.
     *
     * @return
     */
    private ClassLoaderTemplateResolver mailTemplateResolver(){
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("template/contact/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(true);
        return templateResolver;
    }
}

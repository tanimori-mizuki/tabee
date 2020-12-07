package com.example.service.common;

import com.example.domain.common.Contact;
import com.example.form.common.ContactForm;
import com.example.mapper.common.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class ContactService {

    @Autowired
    private ContactMapper contactMapper;
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
    }
}

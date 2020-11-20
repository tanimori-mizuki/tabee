package com.example.controller;


import com.example.domain.Contact;
import com.example.form.ContactForm;
import com.example.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 問合せ内容を登録するコントローラ.
 *
 */
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("")
    public void registerContact(@RequestBody ContactForm contactForm){
        contactService.registerContact(contactForm);
    }
}

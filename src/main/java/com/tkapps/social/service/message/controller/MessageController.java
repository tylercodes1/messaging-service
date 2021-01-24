package com.tkapps.social.service.message.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("This is hello");
        return "Hello, World";
    }
}

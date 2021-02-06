package com.tkapps.social.service.message.controllers;

import com.tkapps.social.service.message.controller.HelloController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    HelloController helloController;

    @BeforeEach
    void setUp() { mockMvc = MockMvcBuilders.standaloneSetup(helloController).build(); }

    @Test
    void testHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }

    @Test
    void testErrorTrue() throws Exception {
        boolean bool = true;
        mockMvc.perform(get("/hello/error/{bool}", bool).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void testErrorFalse() throws Exception {
        mockMvc.perform(get("/hello/error/false").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

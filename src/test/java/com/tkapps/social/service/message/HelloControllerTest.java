package com.tkapps.social.service.message;

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
    void testError() throws Exception {
        mockMvc.perform(get("/error"))
                .andExpect(status().is4xxClientError());
    }
}

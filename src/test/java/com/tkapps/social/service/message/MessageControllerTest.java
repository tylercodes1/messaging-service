package com.tkapps.social.service.message;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.tkapps.social.service.message.controller.MessageController;
import com.tkapps.social.service.message.models.Message;
import com.tkapps.social.service.message.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    @BeforeEach
    public void setup() { this.mockMvc = MockMvcBuilders.standaloneSetup(messageController).build(); }

    Message mockMessage1 = new Message(0, "Hey");
    Message mockMessage2 = new Message(1, "Wassup");

    List<Message> messages = new ArrayList<>();

    /**
     * Tests to make sure MockMVC works
     * @throws Exception
     */
    @Test
    void testMockMVC() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/message/"))
                .andExpect(status().isOk());
//                .andExpect(view().name("message")); TODO figure out what this is
    }

}

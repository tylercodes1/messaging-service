package com.tkapps.social.service.message;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.hasSize;

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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

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

    Message mockMessage0 = new Message(0, "Hey");
    Message mockMessage1 = new Message(1, "Wassup");

    List<Message> messages = new ArrayList<>();

    @Test
    void testFindAll() throws Exception {
        messages.add(mockMessage0);
        messages.add(mockMessage1);
        Mockito.when(messageService.findAll()).thenReturn(messages);
        ResultActions actions = mockMvc.perform(get("/message/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));

        // TODO create more robust testing: add testing to see if fields exist.
        // https://stackoverflow.com/questions/15371022/springmvc-mockmvc-jsonpath-compare-list-of-strings
    }

    @Test
    void testFindByMessageId() throws Exception {
        Mockito.when(messageService.findByMessageId(0)).thenReturn(mockMessage0);
        ResultActions actions = mockMvc.perform(get("/message/0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.messageId",is(0)));
    }
}

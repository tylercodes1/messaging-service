package com.tkapps.social.service.message.service;

import com.tkapps.social.service.message.models.Message;
import com.tkapps.social.service.message.repo.MessageRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    @Mock
    private MessageRepo messageRepo;

    @InjectMocks
    private MessageService messageService;

    @Test
    void testFindAll() {
        Message message = new Message(0, "Hello");
        Message message1 = new Message(1, "What's up");
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        messageList.add(message1);

        when(messageRepo.findAll()).thenReturn(messageList);
        assertEquals(messageList, messageService.findAll());
    }

    @Test
    void testFindById() {
        Message message = new Message(0, "Hello");

        when(messageRepo.findByMessageId(0)).thenReturn(message);
        assertEquals(message, messageService.findByMessageId(0));
    }

    @Test
    void testSuccessfulSave() {
        Message message = new Message(0, "Hello");
        when(messageRepo.save(message)).thenReturn(message);

        assertTrue(messageService.save(message));
    }

    @Test
    void testUnsuccessfulSave() {
        Message message = new Message(0, "Hello");
        when(messageRepo.save(message)).thenThrow(IllegalArgumentException.class);

        assertFalse(messageService.save(message));
    }

}

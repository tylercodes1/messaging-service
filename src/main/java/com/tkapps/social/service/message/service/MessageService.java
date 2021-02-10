package com.tkapps.social.service.message.service;

import com.tkapps.social.service.message.models.DTO.MessageDTO;
import com.tkapps.social.service.message.models.Message;
import com.tkapps.social.service.message.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public List<Message> findAll() { return messageRepo.findAll();}

    public Message findByMessageId(int id) {return messageRepo.findByMessageId(id);}

    public MessageDTO save(MessageDTO messageDTO) {
        if (messageDTO.getMessage() == null)
            throw new IllegalArgumentException();

        try {
            Message message = new Message(0, messageDTO.getMessage());
            return new MessageDTO(messageRepo.save(message).getMessage());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}

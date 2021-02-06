package com.tkapps.social.service.message.service;

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

    public boolean save(Message message) {
        try {
            messageRepo.save(message);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}

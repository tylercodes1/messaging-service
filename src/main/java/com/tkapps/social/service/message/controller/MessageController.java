package com.tkapps.social.service.message.controller;

import com.tkapps.social.service.message.VO.ResponseTemplateVO;
import com.tkapps.social.service.message.models.DTO.MessageDTO;
import com.tkapps.social.service.message.models.Message;
import com.tkapps.social.service.message.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @ApiOperation(value = "Finds all messages in the database.")
    @GetMapping("")
    public List<Message> findAll() {
        return messageService.findAll();
    }

    @ApiOperation(value = "Finds a message by a message id.")
    @GetMapping("/{id}")
    public Message findByMessageId(@PathVariable("id") int id) {
        return messageService.findByMessageId(id);
    }

    @ApiOperation(value = "")
    @PostMapping("")
    public Message save(@RequestBody MessageDTO message) { return messageService.save(message); }

    @ApiOperation(value = "")
    @GetMapping("/full/{id}")
    public ResponseTemplateVO getMessageWithUser(@PathVariable("id") int id) {
        return messageService.getMessageWithUser(id);
    }
}

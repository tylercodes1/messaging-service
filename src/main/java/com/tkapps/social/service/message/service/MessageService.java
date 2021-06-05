package com.tkapps.social.service.message.service;

import com.tkapps.social.service.message.VO.ResponseTemplateVO;
import com.tkapps.social.service.message.VO.User;
import com.tkapps.social.service.message.models.DTO.MessageDTO;
import com.tkapps.social.service.message.models.Message;
import com.tkapps.social.service.message.repo.MessageRepo;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private RestTemplate restTemplate;

    public List<Message> findAll() { return messageRepo.findAll();}

    public Message findByMessageId(int id) {return messageRepo.findByMessageId(id);}

    public Message save(MessageDTO messageDTO) {
        if (messageDTO.getMessage() == null)
            throw new IllegalArgumentException();

        try {
            Message message = new Message(0, messageDTO.getMessage(), messageDTO.getUserId());
            return messageRepo.save(message);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public ResponseTemplateVO getMessageWithUser(int messageId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Message message = messageRepo.findByMessageId(messageId);

        User user = restTemplate.getForObject("http://localhost:8081/users/" + message.getUserId(), User.class);
        vo.setMessage(message);
        vo.setUser(user);

        return vo;
    }
}

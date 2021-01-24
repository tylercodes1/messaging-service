package com.tkapps.social.service.message.repo;

import com.tkapps.social.service.message.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository <Message, Integer> {

    List<Message> findAll();

    Message findByMessageId(int messageId);
}

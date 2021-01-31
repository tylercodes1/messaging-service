package com.tkapps.social.service.message.repo;

import com.tkapps.social.service.message.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository <Message, Integer> {

    Message findByMessageId(int messageId);
}

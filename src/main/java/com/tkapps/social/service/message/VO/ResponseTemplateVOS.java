package com.tkapps.social.service.message.VO;

import com.tkapps.social.service.message.models.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVOS {
    private User user;
    private List<Message> messages;
}

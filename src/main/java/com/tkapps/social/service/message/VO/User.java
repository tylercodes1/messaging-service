package com.tkapps.social.service.message.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
}

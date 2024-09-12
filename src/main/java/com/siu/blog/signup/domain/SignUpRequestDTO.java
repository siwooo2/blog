package com.siu.blog.signup.domain;

import lombok.Data;

@Data
public class SignUpRequestDTO {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private int birthdate;
}

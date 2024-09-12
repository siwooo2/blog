package com.siu.blog.login.domain;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}

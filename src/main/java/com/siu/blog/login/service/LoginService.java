package com.siu.blog.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siu.blog.login.dao.LoginMapper;
import com.siu.blog.login.domain.LoginRequestDTO;
import com.siu.blog.login.domain.LoginResponseDTO;

@Service
public class LoginService {
    
    @Autowired
    private LoginMapper loginMapper;

    public Boolean login(LoginRequestDTO params){
        return loginMapper.login(params);   
    }

    public LoginResponseDTO getUser(LoginRequestDTO params){
        return loginMapper.getUser(params);
    }
}

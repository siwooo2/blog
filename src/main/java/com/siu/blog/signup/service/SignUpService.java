package com.siu.blog.signup.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.siu.blog.signup.dao.SignUpMapper;
import com.siu.blog.signup.domain.DuplicationRequestDTO;
import com.siu.blog.signup.domain.SignUpRequestDTO;

@Service
public class SignUpService {
    
    @Autowired
    private SignUpMapper signUpMapper;

    
    public Boolean signUp(SignUpRequestDTO params){
            signUpMapper.signUp(params);
            return true;
    }

    public Boolean dupl(DuplicationRequestDTO params){
        
        return signUpMapper.selectUser(params);
    }
}

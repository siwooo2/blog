package com.siu.blog.signup.dao;

import org.apache.ibatis.annotations.Mapper;

import com.siu.blog.signup.domain.DuplicationRequestDTO;
import com.siu.blog.signup.domain.SignUpRequestDTO;

@Mapper
public interface SignUpMapper {
    
    public void signUp(SignUpRequestDTO params);

    public boolean selectUser(DuplicationRequestDTO params);
}
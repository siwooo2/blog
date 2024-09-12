package com.siu.blog.login.dao;

import org.apache.ibatis.annotations.Mapper;

import com.siu.blog.login.domain.LoginRequestDTO;
import com.siu.blog.login.domain.LoginResponseDTO;

@Mapper
public interface LoginMapper {

    public boolean login(LoginRequestDTO params);

    public LoginResponseDTO getUser(LoginRequestDTO params);
}
package com.siu.blog.login.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siu.blog.login.domain.LoginRequestDTO;
import com.siu.blog.login.domain.LoginResponseDTO;
import com.siu.blog.login.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDTO params) {
        
        Boolean result = loginService.login(params);
        
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/getuser")
    public ResponseEntity<LoginResponseDTO> getUser(@RequestBody LoginRequestDTO params) {
        LoginResponseDTO result = loginService.getUser(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    
}

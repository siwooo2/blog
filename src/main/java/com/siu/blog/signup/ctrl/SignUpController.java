package com.siu.blog.signup.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siu.blog.signup.domain.DuplicationRequestDTO;
import com.siu.blog.signup.domain.SignUpRequestDTO;
import com.siu.blog.signup.service.SignUpService;



@RestController
@RequestMapping("/api")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signUp(@RequestBody SignUpRequestDTO params) {
        Boolean result = signUpService.signUp(params);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/duplication")
    public ResponseEntity<Boolean> postMethodName(@RequestBody DuplicationRequestDTO params) {
        Boolean result = signUpService.dupl(params);
        
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}

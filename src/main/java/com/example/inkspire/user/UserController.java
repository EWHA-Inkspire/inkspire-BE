package com.example.inkspire.user;

import com.example.inkspire.common.ResponseDto;
import com.example.inkspire.user.model.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup(@RequestBody SignupDto signupDto) {
        ResponseDto response = userService.createMember(signupDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }
}

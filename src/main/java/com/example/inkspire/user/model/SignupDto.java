package com.example.inkspire.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupDto {
    private String email;
    private String password;
    private String nickname;
}

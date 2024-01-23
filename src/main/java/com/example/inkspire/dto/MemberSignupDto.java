package com.example.inkspire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDto {
    private String email;
    private String password;
    private String nickname;

    public MemberDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

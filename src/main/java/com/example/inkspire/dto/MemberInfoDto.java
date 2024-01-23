package com.example.inkspire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberInfoDto {
    private Long id;
    private String email;
    private String nickname;
}

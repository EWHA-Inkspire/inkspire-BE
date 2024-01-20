package com.example.inkspire.controller;

import com.example.inkspire.config.GeneralException;
import com.example.inkspire.config.ResponseCode;
import com.example.inkspire.dto.MemberDto;
import com.example.inkspire.dto.ResponseDto;
import com.example.inkspire.service.MemberService;
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
public class MemberController {
    private final MemberService memberService;

    /* 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup(@RequestBody MemberDto memberDto) {
        if (memberService.createMember(memberDto)) {
            return new ResponseEntity<>(ResponseDto.of(true, ResponseCode.OK, "회원가입 성공."), HttpStatus.OK);
        }
        throw new GeneralException(ResponseCode.BAD_REQUEST, "잘못된 입력값입니다.");
    }
}

package com.example.inkspire.controller;

import com.example.inkspire.dto.*;
import com.example.inkspire.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {
    private final MemberService memberService;

    /* 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup(@Validated @RequestBody MemberSignupDto memberSignupDto) {
        return new ResponseEntity<>(memberService.createMember(memberSignupDto), HttpStatus.OK);
    }

    /* 로그인 */
    @PostMapping("/login")
    public ResponseEntity<DataResponseDto<Long>> login(@Validated @RequestBody Map<String, String> map) {
        return new ResponseEntity<>(memberService.join(map.get("email"), map.get("password")), HttpStatus.OK);
    }

    /* 프로필 정보 조회 */
    @GetMapping("/profile")
    public ResponseEntity<DataResponseDto<MemberInfoDto>> profile(@Validated @RequestParam Long id) {
        return new ResponseEntity<>(memberService.getMemberInfo(id), HttpStatus.OK);
    }
}

package com.example.inkspire.service;

import com.example.inkspire.config.GeneralException;
import com.example.inkspire.config.ResponseCode;
import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.dto.MemberSignupDto;
import com.example.inkspire.dto.MemberInfoDto;
import com.example.inkspire.dto.ResponseDto;
import com.example.inkspire.entity.Member;
import com.example.inkspire.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    /* 회원가입 */
    public ResponseDto createMember(MemberSignupDto memberSignupDto) {
        Member member = new Member();

        // 이메일 중복 검증
        if (!validateDuplicated(memberSignupDto)) {
            return ResponseDto.of(false, ResponseCode.BAD_REQUEST, "회원가입 실패");
        }

        member.setEmail(memberSignupDto.getEmail());
        member.setPassword(memberSignupDto.getPassword());
        member.setNickname(memberSignupDto.getNickname());

        memberRepository.save(member);

        return ResponseDto.of(true, ResponseCode.OK, "회원가입 성공");
    }

    private boolean validateDuplicated(MemberSignupDto memberSignupDto) {
        return memberRepository.findByEmail(memberSignupDto.getEmail()) == null;
    }

    public DataResponseDto<Long> join(String email, String password) {
        Member member = memberRepository.findByEmail(email);

        if (!member.getPassword().equals(password)) {
            throw new GeneralException(ResponseCode.BAD_REQUEST, "로그인 실패");
        }
        return DataResponseDto.of(member.getId(), "로그인 성공");
    }
}

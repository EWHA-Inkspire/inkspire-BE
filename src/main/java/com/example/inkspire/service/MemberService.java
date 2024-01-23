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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /* 회원가입 */
    public ResponseDto createMember(MemberSignupDto memberSignupDto) {
        Member member = new Member();

        // 이메일 중복 검증
        if (!validateDuplicated(memberSignupDto)) {
            return ResponseDto.of(false, ResponseCode.BAD_REQUEST, "회원가입 실패");
        }

        String encodedPw = passwordEncoder.encode(memberSignupDto.getPassword());

        member.setEmail(memberSignupDto.getEmail());
        member.setPassword(encodedPw);
        member.setNickname(memberSignupDto.getNickname());

        memberRepository.save(member);

        return ResponseDto.of(true, ResponseCode.OK, "회원가입 성공");
    }

    private boolean validateDuplicated(MemberSignupDto memberSignupDto) {
        return memberRepository.findByEmail(memberSignupDto.getEmail()) == null;
    }

    public DataResponseDto<MemberInfoDto> join(String email, String password) {
        Member member = memberRepository.findByEmail(email);

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new GeneralException(ResponseCode.BAD_REQUEST, "로그인 실패");
        }
        return DataResponseDto.of(new MemberInfoDto(member.getId(), member.getEmail(), member.getNickname()), "로그인 성공");
    }
}

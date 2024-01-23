package com.example.inkspire.service;

import com.example.inkspire.dto.MemberDto;
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
    public boolean createMember(MemberDto memberDto) {
        Member member = new Member();

        // 이메일 중복 검증 & null 값 혹은 빈 값 검사
        if (isNullValue(memberDto) || !validateDuplicated(memberDto)) {
            return false;
        }

        String encodedPw = passwordEncoder.encode(memberDto.getPassword());

        member.setEmail(memberDto.getEmail());
        member.setPassword(encodedPw);
        member.setNickname(memberDto.getNickname());

        memberRepository.save(member);

        return true;
    }

    private boolean isNullValue(MemberDto memberDto) {
        return memberDto.getEmail() == null || memberDto.getPassword() == null || memberDto.getNickname() == null
                || memberDto.getEmail().isEmpty() || memberDto.getPassword().isEmpty() || memberDto.getNickname().isEmpty();
    }

    private boolean validateDuplicated(MemberDto memberDto) {
        return memberRepository.findByEmail(memberDto.getEmail()) == null;
    }
}

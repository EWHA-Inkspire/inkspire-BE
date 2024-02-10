package com.example.inkspire.user;

import com.example.inkspire.common.DataResponseDto;
import com.example.inkspire.common.ResponseDto;
import com.example.inkspire.common.errors.ErrorCode;
import com.example.inkspire.common.errors.GeneralException;
import com.example.inkspire.config.ShaUtil;
import com.example.inkspire.user.model.LoginDto;
import com.example.inkspire.user.model.SignupDto;
import com.example.inkspire.user.model.User;
import com.example.inkspire.user.model.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /* 회원가입 */
    public ResponseDto createMember(SignupDto signupDto) {
        User user = new User();

        // 이메일 중복 검증
        if (!validateDuplicated(signupDto.getEmail())) {
            throw new GeneralException(ErrorCode.USER_EMAIL_DUPLICATED);
        }

        // 비밀번호 암호화
        String salt = ShaUtil.getSalt();
        String encryptedPw = ShaUtil.getEncryptPw(signupDto.getPassword(), salt);

        // 유저 정보 추가
        user.setEmail(signupDto.getEmail());
        user.setNickname(signupDto.getNickname());
        user.setSalt(salt);
        user.setPassword(encryptedPw);

        userRepository.save(user);

        return ResponseDto.success(HttpStatus.CREATED);
    }

    /* 이메일 중복 검증 */
    private boolean validateDuplicated(String email) {
        return userRepository.findByEmail(email).isEmpty();
    }

    /* 로그인 */
    public DataResponseDto<Long> join(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        if (!checkPassword(user, password)) {
            throw new GeneralException(ErrorCode.USER_WRONG_PASSWORD);
        }

        return DataResponseDto.of(user.getId());
    }

    /* 비밀번호 검증 */
    private boolean checkPassword(User user, String password) {
        String salt = user.getSalt();
        String encryptedPw = ShaUtil.getEncryptPw(password, salt);

        return encryptedPw.equals(user.getPassword());
    }

    /* 프로필 정보 조회 */
    public DataResponseDto<UserInfoDto> getMemberInfo(Long memberId) {
        UserInfoDto userInfo = userRepository.findMemberInfoById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        return DataResponseDto.of(userInfo);
    }

}

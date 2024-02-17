package com.example.inkspire.user;

import com.example.inkspire.character.model.CharacterInfoDto;
import com.example.inkspire.character.model.CharacterListDto;
import com.example.inkspire.common.errors.ErrorCode;
import com.example.inkspire.common.errors.GeneralException;
import com.example.inkspire.config.ShaUtil;
import com.example.inkspire.user.model.LoginDto;
import com.example.inkspire.user.model.SignupDto;
import com.example.inkspire.user.model.User;
import com.example.inkspire.user.model.UserInfoDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /* 회원가입 */
    public void createMember(SignupDto signupDto) {

        // 이메일 중복 검증
        if (!validateDuplicated(signupDto.getEmail())) {
            throw new GeneralException(ErrorCode.USER_EMAIL_DUPLICATED);
        }

        // 비밀번호 암호화
        String salt = ShaUtil.getSalt();
        String encryptedPw = ShaUtil.getEncryptPw(signupDto.getPassword(), salt);

        // 유저 정보 추가
        User user = User.builder().email(signupDto.getEmail())
                .nickname(signupDto.getNickname())
                .salt(salt)
                .password(encryptedPw)
                .build();

        userRepository.save(user);
    }

    /* 이메일 중복 검증 */
    private boolean validateDuplicated(String email) {
        return userRepository.findByEmail(email).isEmpty();
    }

    /* 로그인 */
    public Long join(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        if (!checkPassword(user, password)) {
            throw new GeneralException(ErrorCode.USER_WRONG_PASSWORD);
        }

        return user.getId();
    }

    /* 비밀번호 검증 */
    private boolean checkPassword(User user, String password) {
        String salt = user.getSalt();
        String encryptedPw = ShaUtil.getEncryptPw(password, salt);

        return encryptedPw.equals(user.getPassword());
    }

    /* 캐릭터 리스트 조회 */
    public CharacterListDto getCharacterList(Long id) {
        // 유저가 존재하는지 검증
        userRepository.findById(id)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));

        List<CharacterInfoDto> characterList = userRepository.findCharactersByUserId(id);

        if (characterList.isEmpty()) {
            // 캐릭터 리스트가 없을 경우에 대한 예외 처리 -> 빈 리스트를 반환
            return new CharacterListDto();
        } else {
            return new CharacterListDto(characterList);
        }
    }

    /* 프로필 정보 조회 */
    public UserInfoDto gerUserInfo(Long userId) {
        return userRepository.findMemberInfoById(userId)
                .orElseThrow(() -> new GeneralException(ErrorCode.USER_NOT_FOUND));
    }

}

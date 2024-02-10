package com.example.inkspire.user;

import com.example.inkspire.common.DataResponseDto;
import com.example.inkspire.common.ResponseDto;
import com.example.inkspire.user.model.LoginDto;
import com.example.inkspire.user.model.SignupDto;
import com.example.inkspire.user.model.UserInfoDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /* 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup(@RequestBody @Valid SignupDto signupDto) {
        ResponseDto response = userService.createMember(signupDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    /* 로그인 */
    @PostMapping("/login")
    public ResponseEntity<DataResponseDto<Long>> login(@RequestBody @Valid LoginDto loginDto) {
        return new ResponseEntity<>(userService.join(loginDto), HttpStatus.OK);
    }

    /* 프로필 정보 조회 */
    @GetMapping("/{userId}/profile")
    public ResponseEntity<DataResponseDto<UserInfoDto>> profile(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.gerUserInfo(userId), HttpStatus.OK);
    }
}

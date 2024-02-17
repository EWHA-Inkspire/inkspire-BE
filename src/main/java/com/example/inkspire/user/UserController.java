package com.example.inkspire.user;

import com.example.inkspire.character.model.CharacterListDto;
import com.example.inkspire.common.response.Response;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /* 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<Response> signup(@RequestBody @Valid SignupDto signupDto) {
        userService.createMember(signupDto);

        return Response.of(HttpStatus.CREATED);
    }

    /* 로그인 */
    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody @Valid LoginDto loginDto) {
        Long userId = userService.join(loginDto);

        return Response.of(HttpStatus.OK, userId);
    }

    /* 캐릭터 리스트 조회 */
    @GetMapping("{userId}/characterList")
    public ResponseEntity<Response> getCharacterList(@PathVariable Long userId) {
        CharacterListDto characterList = userService.getCharacterList(userId);

        return Response.of(HttpStatus.OK, characterList);
    }

    /* 프로필 정보 조회 */
    @GetMapping("/{userId}/profile")
    public ResponseEntity<Response> profile(@PathVariable Long userId) {
        UserInfoDto userInfoDto = userService.gerUserInfo(userId);

        return Response.of(HttpStatus.OK, userInfoDto);
    }
}

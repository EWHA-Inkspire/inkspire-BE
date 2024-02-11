package com.example.inkspire.common;

import com.example.inkspire.character.CharacterRepository;
import com.example.inkspire.common.errors.ErrorCode;
import com.example.inkspire.common.errors.GeneralException;
import com.example.inkspire.user.UserRepository;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    private final UserRepository userRepository;
    private final CharacterRepository characterRepository;

    @Autowired
    public AuthenticationAspect(UserRepository userRepository, CharacterRepository characterRepository) {
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
    }

    @Before("@annotation(com.example.inkspire.common.annotation.UserAuthentication) && args(userId,..)")
    public void authenticateUser(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new GeneralException(ErrorCode.USER_NOT_FOUND);
        }
    }

    @Before("@annotation(com.example.inkspire.common.annotation.CharacterAuthentication) && args(characterId,..)")
    public void authenticateCharacter(Long characterId) {
        if (!characterRepository.existsById(characterId)) {
            throw new GeneralException(ErrorCode.CHARACTER_NOT_FOUND);
        }
    }
}

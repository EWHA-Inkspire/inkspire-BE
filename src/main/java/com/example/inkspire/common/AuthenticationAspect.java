package com.example.inkspire.common;

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

    @Autowired
    public AuthenticationAspect(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Before("@annotation(com.example.inkspire.common.annotation.RequiresAuthentication) && args(userId,..)")
    public void authenticate(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new GeneralException(ErrorCode.USER_NOT_FOUND);
        }
    }
}

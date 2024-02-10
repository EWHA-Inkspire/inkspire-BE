package com.example.inkspire.common;

import com.example.inkspire.user.UserRepository;
import com.example.inkspire.user.model.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UserExistValidator implements ConstraintValidator<UserExist, Long> {
    private final UserRepository userRepository;

    public UserExistValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UserExist constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long userId, ConstraintValidatorContext context) {
        if (userId == null) {
            return true; // null 값은 검증에서 제외
        }

        // 데이터베이스에서 사용자 조회
        Optional<User> userOptional = userRepository.findById(userId);

        // 사용자가 존재하는지 확인
        return userOptional.isPresent();
    }
}

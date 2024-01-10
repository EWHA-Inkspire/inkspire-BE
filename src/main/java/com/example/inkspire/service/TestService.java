package com.example.inkspire.service;

import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.dto.TestDto;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public DataResponseDto<TestDto> testMethod() {
        return DataResponseDto.of(new TestDto("hello World"));
    }
}

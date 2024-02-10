package com.example.inkspire.example;

import com.example.inkspire.common.DataResponseDto;
import com.example.inkspire.common.PageInfoDto;
import com.example.inkspire.common.PageResponseDto;
import com.example.inkspire.common.ResponseDto;
import com.example.inkspire.common.errors.ErrorCode;
import com.example.inkspire.common.errors.GeneralException;
import com.example.inkspire.example.model.TestDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public DataResponseDto<TestDto> testDataResponse() {
        return DataResponseDto.of(new TestDto("hello World!"));
    }

    public ResponseDto testResponse() {
        return ResponseDto.success(HttpStatus.OK);
    }

    public DataResponseDto<TestDto> testException() {
        throw new GeneralException(ErrorCode.USER_UNAUTHORIZED);
    }

    public PageResponseDto<TestDto> testPage() {
        return PageResponseDto.of(new TestDto("pagination test!"), new PageInfoDto(1, 5, 10L, 2));
    }
}

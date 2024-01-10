package com.example.inkspire.dto;

import com.example.inkspire.config.ResponseCode;

public class ErrorResponseDto extends ResponseDto {

    private ErrorResponseDto(ResponseCode errorResponseCode) {
        super(false, errorResponseCode.getCode(), errorResponseCode.getMessage());
    }

    private ErrorResponseDto(ResponseCode errorResponseCode, Exception e) {
        super(false, errorResponseCode.getCode(), errorResponseCode.getMessage(e));
    }

    private ErrorResponseDto(ResponseCode errorResponseCode, String message) {
        super(false, errorResponseCode.getCode(), errorResponseCode.getMessage(message));
    }


    public static ErrorResponseDto of(ResponseCode errorResponseCode) {
        return new ErrorResponseDto(errorResponseCode);
    }

    public static ErrorResponseDto of(ResponseCode errorResponseCode, Exception e) {
        return new ErrorResponseDto(errorResponseCode, e);
    }

    public static ErrorResponseDto of(ResponseCode errorResponseCode, String message) {
        return new ErrorResponseDto(errorResponseCode, message);
    }
}

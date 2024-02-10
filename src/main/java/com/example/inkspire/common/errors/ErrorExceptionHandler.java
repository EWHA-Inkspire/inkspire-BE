package com.example.inkspire.common.errors;

import com.example.inkspire.common.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleException(Exception e) {
        return new ResponseEntity<>(ResponseDto.error(ErrorCode.SERVER_ERROR, e),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ResponseDto> handleGeneralException(GeneralException e) {
        return new ResponseEntity<>(ResponseDto.error(e.getErrorCode(), e),
                e.getErrorCode().getHttpStatus());
    }
}

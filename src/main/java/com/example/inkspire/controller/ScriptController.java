package com.example.inkspire.controller;

import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.dto.ScriptDto;
import com.example.inkspire.service.ScriptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/script")
public class ScriptController {
    private final ScriptService scriptService;
    /* 스크립트 정보 저장 */
    @PostMapping("/create")
    public ResponseEntity<DataResponseDto<Long>> createScript(@Validated @RequestBody ScriptDto scriptDto) {
        return new ResponseEntity<>(scriptService.createScript(scriptDto), HttpStatus.OK);
    }
}

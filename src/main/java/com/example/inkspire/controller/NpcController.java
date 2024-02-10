package com.example.inkspire.controller;

import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.dto.NpcInfoDto;
import com.example.inkspire.service.NpcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/npc")
public class NpcController {

    private final NpcService npcService;

    @PostMapping("/create")
    public ResponseEntity<DataResponseDto<Long>> createNpc(@RequestBody NpcInfoDto npcInfoDto) {
        return new ResponseEntity<>(npcService.createNpc(npcInfoDto), HttpStatus.OK);
    }


}

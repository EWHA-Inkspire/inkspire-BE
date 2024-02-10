package com.example.inkspire.controller;

import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.dto.MapDto;
import com.example.inkspire.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {
    private final MapService mapService;

    /* 맵 정보 저장 */
    @PostMapping("/create")
    public ResponseEntity<DataResponseDto<Long>> createCharacter(@RequestBody MapDto mapDto) {
        return new ResponseEntity<>(mapService.createMap(mapDto), HttpStatus.OK);
    }
}

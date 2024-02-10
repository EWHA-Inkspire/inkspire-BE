package com.example.inkspire.service;

import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.dto.MapDto;
import com.example.inkspire.entity.Map;
import com.example.inkspire.entity.Script;
import com.example.inkspire.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {
    @Autowired
    private MapRepository mapRepository;

    /* 맵 정보 저장 */
    public DataResponseDto<Long> createMap(MapDto mapDto) {
        Map map = new Map();

        map.setScript(Script.builder().id(mapDto.getScriptId()).build());
        map.setName(mapDto.getName());
        map.setChapter(mapDto.getChapter());
        map.setEventTrigger(mapDto.getEventTrigger());
        map.setEventType(mapDto.getEventType());
        map.setLastVisited(false);

        Map saved = mapRepository.save(map);

        return DataResponseDto.of(saved.getId());
    }
}

package com.example.inkspire.service;

import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.dto.ScriptDto;
import com.example.inkspire.entity.Characters;
import com.example.inkspire.entity.CommonCode;
import com.example.inkspire.entity.Script;
import com.example.inkspire.repository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScriptService {
    @Autowired
    private ScriptRepository scriptRepository;

    /* 스크립트 정보 저장 */
    public DataResponseDto<Long> createScript(ScriptDto scriptDto) {
        Script script = new Script();

        script.setCharacter(Characters.builder().id(scriptDto.getCharacterId()).build());
        script.setTime(scriptDto.getTime());
        script.setPlace(scriptDto.getPlace());
        script.setGenre(CommonCode.builder().id(scriptDto.getGenreId()).build());

        Script saved = scriptRepository.save(script);

        return DataResponseDto.of(saved.getId());
    }
}

package com.example.inkspire.service;

import com.example.inkspire.dto.DataResponseDto;
import com.example.inkspire.dto.NpcInfoDto;
import com.example.inkspire.entity.Map;
import com.example.inkspire.entity.Npc;
import com.example.inkspire.repository.NpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NpcService {

    @Autowired
    private NpcRepository npcRepository;

    /* npc 정보 저장 */
    public DataResponseDto<Long> createNpc(NpcInfoDto npcInfoDto) {
        Npc npc = new Npc();

        npc.setName(npcInfoDto.getName());
        npc.setMap(Map.builder().id(npcInfoDto.getMapId()).build());
        npc.setPnpc(npcInfoDto.isPnpc());
        npc.setGreeting(npcInfoDto.getGreeting());

        Npc saved = npcRepository.save(npc);

        return DataResponseDto.of(saved.getId());
    }
}

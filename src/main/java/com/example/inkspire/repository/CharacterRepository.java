package com.example.inkspire.repository;

import com.example.inkspire.entity.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Characters, Long> {
    Optional<Characters> findAllByMemberId(Long memberId);

    // 캐릭터 별 목표가 생성된 챕터 조회
    @Query(value = "SELECT g.chapter " +
                    "FROM characters c " +
                    "LEFT JOIN script s ON c.id = s.character_id " +
                    "LEFT JOIN goal g ON s.id = g.script_id " +
                    "WHERE c.id = :characterId", nativeQuery = true)
    List<Integer> findChapterByCharacterId(Long characterId);

}

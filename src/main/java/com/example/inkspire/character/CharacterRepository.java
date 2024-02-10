package com.example.inkspire.character;

import com.example.inkspire.character.model.Character;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    Optional<Character> findAllByUserId(Long userId);

    // 캐릭터 별 목표가 생성된 챕터 조회
    @Query(value = "SELECT g.chapter " +
            "FROM characters c " +
            "LEFT JOIN script s ON c.id = s.character_id " +
            "LEFT JOIN goal g ON s.id = g.script_id " +
            "WHERE c.id = :characterId", nativeQuery = true)
    List<Integer> findChapterByCharacterId(Long characterId);

}

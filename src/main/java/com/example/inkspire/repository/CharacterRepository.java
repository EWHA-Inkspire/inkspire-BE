package com.example.inkspire.repository;

import com.example.inkspire.entity.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Characters, Long> {
    Optional<Characters> findAllByMemberId(Long memberId);

}

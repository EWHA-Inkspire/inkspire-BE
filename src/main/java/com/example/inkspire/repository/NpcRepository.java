package com.example.inkspire.repository;

import com.example.inkspire.entity.Npc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcRepository extends JpaRepository<Npc, Long> {

}

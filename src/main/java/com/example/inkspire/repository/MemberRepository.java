package com.example.inkspire.repository;

import com.example.inkspire.dto.MemberInfoDto;
import com.example.inkspire.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    @Query(value = "SELECT m.id, m.email, m.nickname, COUNT(s.id) AS endingCount " +
            "FROM member m " +
            "JOIN characters c ON m.id = c.member_id " +
            "LEFT JOIN script s ON c.id = s.character_id AND s.ending = true " +
            "WHERE m.id = :memberId " +
            "GROUP BY m.id, m.email, m.nickname", nativeQuery = true)
    Optional<MemberInfoDto> findMemberInfoBy(Long memberId);
}

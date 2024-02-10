package com.example.inkspire.user;

import com.example.inkspire.user.model.User;
import com.example.inkspire.user.model.UserInfoDto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT m.id, m.email, m.nickname, COUNT(s.id) AS endingCount "
            + "FROM member m "
            + "JOIN characters c ON m.id = c.member_id "
            + "LEFT JOIN script s ON c.id = s.character_id AND s.ending = true "
            + "WHERE m.id = :memberId "
            + "GROUP BY m.id, m.email, m.nickname", nativeQuery = true)
    Optional<UserInfoDto> findMemberInfoById(Long memberId);
}

package com.example.inkspire.user;

import com.example.inkspire.character.model.Character;
import com.example.inkspire.character.model.CharacterInfoDto;
import com.example.inkspire.user.model.User;
import com.example.inkspire.user.model.UserInfoDto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT c.id, c.name, c.success, c.fail FROM characters c WHERE c.user_id = :userId", nativeQuery = true)
    List<CharacterInfoDto> findCharactersByUserId(Long userId);

    @Query(value = "SELECT u.email, u.nickname, COUNT(s.id) AS endingCount "
            + "FROM user u "
            + "LEFT JOIN characters c ON u.id = c.user_id "
            + "LEFT JOIN script s ON c.id = s.character_id AND s.ending = true "
            + "WHERE u.id = :userId "
            + "GROUP BY u.id, u.email, u.nickname "
            + "limit 1", nativeQuery = true)
    Optional<UserInfoDto> findMemberInfoById(Long userId);
}

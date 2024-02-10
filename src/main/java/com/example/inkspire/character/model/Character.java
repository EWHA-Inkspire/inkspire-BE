package com.example.inkspire.character.model;

import com.example.inkspire.common.BaseTime;
import com.example.inkspire.user.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "characters")
public class Character extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "luck", nullable = false)
    private Integer luck;

    @Column(name = "defense", nullable = false)
    private Integer defense;

    @Column(name = "mental", nullable = false)
    private Integer mental;

    @Column(name = "agility", nullable = false)
    private Integer agility;

    @Column(name = "attack", nullable = false)
    private Integer attack;

    @Column(name = "hp", nullable = false)
    private Integer hp;

    @Column(name = "success")
    private String success;

    @Column(name = "fail")
    private String fail;

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", luck=" + luck +
                ", defense=" + defense +
                ", mental=" + mental +
                ", agility=" + agility +
                ", attack=" + attack +
                ", hp=" + hp +
                ", success='" + success + '\'' +
                ", fail='" + fail + '\'' +
                '}';
    }
}

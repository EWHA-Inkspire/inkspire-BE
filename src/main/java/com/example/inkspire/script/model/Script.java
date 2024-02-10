package com.example.inkspire.script.model;

import com.example.inkspire.character.model.Character;
import com.example.inkspire.common.CommonCode;
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
@Table(name = "script")
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "genre", nullable = false)
    private CommonCode genre;

    @Column(name = "universe")
    private String universe;

    @Column(name = "ending", nullable = false)
    private boolean ending;
}

package com.example.inkspire.script.model;

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
@Table(name = "goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "script_id", nullable = false)
    private Script script;

    @Column(name = "chapter", nullable = false)
    private Integer chapter;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "required", nullable = false)
    private String required;

    @Column(name = "type", nullable = false)
    private CommonCode type;

    @Column(name = "etc", nullable = false)
    private String etc;

    @Column(name = "achieved", nullable = false)
    private boolean achieved;
}

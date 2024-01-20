package com.example.inkspire.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommonCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "description")
    private String description;
}

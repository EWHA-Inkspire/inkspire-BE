package com.example.inkspire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ChapterListDto {
    private List<Integer> chapters;
}

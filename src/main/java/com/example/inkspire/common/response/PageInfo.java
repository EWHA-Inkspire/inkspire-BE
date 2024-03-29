package com.example.inkspire.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageInfo {

    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
}

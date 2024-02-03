package com.sesac.sesac.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime registered;
}

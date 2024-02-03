package com.sesac.sesac.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime registered;
}

package com.sesac.sesac.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {
    // 보드 테이블 데이터베이스의 실제 컬럼 반영, 이름이 실제 데이터와 명확하게 같아야한다.
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime registered;

}

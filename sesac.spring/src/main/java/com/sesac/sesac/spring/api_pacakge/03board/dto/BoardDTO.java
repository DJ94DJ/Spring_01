package com.sesac.sesac.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

// DTO는 값을 전달하기 위한 것이므로 실제 데이터배이스 보드테이블에 표기된 이름과 달라도됨.
public class BoardDTO {
    // HTML 작성 SQL 데이터 반영시 이 이름으로 적어야 함.
    private int BoardId;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime registered;
    // 이건 새로 추가한거
    private int no;


}

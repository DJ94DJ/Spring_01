package com.sesac.sesac.spring.jpaboard.repository;


import com.sesac.sesac.spring.jpaboard.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository
        extends JpaRepository<BoardEntity, Integer> {


    // title이 일치 or 검색어가 비어있음

    // 테이블 명이 아닌 내가 정한 엔티티 명을 기입
    @Query("select b from BoardEntity b where (b.title= :word or :word = '')")
    List<BoardEntity> searchByWord(String word);
}
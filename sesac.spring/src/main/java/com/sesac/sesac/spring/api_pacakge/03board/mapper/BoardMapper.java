package com.sesac.sesac.spring.mapper;
import com.sesac.sesac.spring.domain.Board;
//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

// 1) mapper 에는 메소드가 있고, xml에는 없는 경우 -> 실행했을 때 오류
// 2) xml 에는 있고, mapper 에는 없는 경우 -> 실행 자체가 안 된다

//    @Select("select * from board") 전체조회
    public List<Board> getAllBoards();

    void insertBoard(Board board); // 삽입 (insert)

    void patchBoard(Board board); // 수정 (update)

    void deleteBoard(int id); // 삭제 (delete)

    List<Board> searchBoard(String word); // 리스트를 반환하는 검색



}

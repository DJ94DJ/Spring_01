package com.sesac.sesac.spring.mapper;
import com.sesac.sesac.spring.dto.BoardDTO;
//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

//    @Select("select * from board")
    public List<BoardDTO> getAllBoards();

    // 글 작성
//    @Insert("insert into board(title, content, writer) values(#{title}, #{content}, #{writer})")
    public void createPost(String title, String content, String writer);

}

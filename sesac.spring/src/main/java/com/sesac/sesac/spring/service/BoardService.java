package com.sesac.sesac.spring.service;

import com.sesac.sesac.spring.dto.BoardDTO;
import com.sesac.sesac.spring.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    public List<BoardDTO> getAllBoards() {
        List<BoardDTO> result = boardMapper.getAllBoards();
      return result;
    }

    public void createPost(String title, String content, String writer) {
        boardMapper.createPost(title, content, writer);
    }

}

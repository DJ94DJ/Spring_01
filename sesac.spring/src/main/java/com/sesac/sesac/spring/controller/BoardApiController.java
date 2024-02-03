package com.sesac.sesac.spring.controller;


import com.sesac.sesac.spring.dto.BoardDTO;
import com.sesac.sesac.spring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pj01")
public class BoardApiController {

    @Autowired
    private BoardService boardService;


    @GetMapping("/a")
    public ResponseEntity<List<BoardDTO>> getBoard() {
        List<BoardDTO> result = boardService.getAllBoards();
        return ResponseEntity.ok(result);
    }

    @GetMapping ("/all")
    public List<BoardDTO> list() {
        return boardService.getAllBoards();
    }

    @PostMapping ("/createPost")
    public void create(@RequestBody BoardDTO boardDTO) {
        boardService.createPost(
                boardDTO.getTitle(),
                boardDTO.getContent(),
                boardDTO.getWriter()
        );
    }




}

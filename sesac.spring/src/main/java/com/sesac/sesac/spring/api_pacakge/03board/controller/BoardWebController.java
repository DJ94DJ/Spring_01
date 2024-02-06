package com.sesac.sesac.spring.controller;

// 기본적으로 깔아둬야 하는거 - 도메인(SQL 데이터베이스와 일치) -> DTO(해당 도메인 연결하고 이름 가공)
// 순서 기능별로 컨트롤러 만들고 - 서비스 만들고 - 자바매퍼 - xml 매퍼(SQL 명령어)

import com.sesac.sesac.spring.dto.BoardDTO;
import com.sesac.sesac.spring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/board/mybatis")
public class BoardWebController {

    @Autowired
    BoardService boardService;

    // 1. 전체 조회
    @GetMapping("")
    public String getBoard(Model model) {
        List<BoardDTO> result = boardService.getAllBoards();
        model.addAttribute("posts", result);
        return "PJ01_board";
    }

    @PostMapping("") // / board/mybatis
    @ResponseBody // 응답을 주기 위함
    public boolean insetBoard(@RequestBody BoardDTO boardDTO)  {
        // 2. 게시글 작성
        boardService.insertBoard(boardDTO);
        return true;
    }

    @PatchMapping("") // /board/mybatis
    @ResponseBody
    // ResponseBody가 없을시 템플릿 파일을 보여주는데 void일 경우 현재 template 을 그대로 반영하지 못한다.
    public void patchBoard(@RequestBody BoardDTO boardDTO) { // 응답 값 없음
        boardService.patchBoard(boardDTO);
    }

    @DeleteMapping("") // 실제 경로 /board/mybatis
    @ResponseBody
    public void deleteBoard(@RequestParam int id) {
        boardService.deleteBoard(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public int searchBoard(@RequestParam String word){
        return boardService.searchBoard(word); // 정수로 리턴
    }






}

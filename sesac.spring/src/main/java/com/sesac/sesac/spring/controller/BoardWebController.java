package com.sesac.sesac.spring.controller;



import com.sesac.sesac.spring.dto.BoardDTO;
import com.sesac.sesac.spring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/Pj01")
public class BoardWebController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String getBoard(Model model) {
        List<BoardDTO> result = boardService.getAllBoards();
        model.addAttribute("posts", result);
        return "PJ01_board";
    }


}

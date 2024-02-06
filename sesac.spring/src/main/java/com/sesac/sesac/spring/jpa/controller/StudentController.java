package com.sesac.sesac.spring.jpa.controller;

import com.sesac.sesac.spring.jpa.DTO.StudentDTO;
import com.sesac.sesac.spring.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
//    @GetMapping("/count")
//    public int getCountAll(){}
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<StudentDTO> getAll(){
        // student의 목록을 전부 가져와서 보여주는 API
        return studentService.getStudentAll();
    }


//    @GetMapping("/search")
//    public ? getSearch(@RequestBody int id){}
}
package com.sesac.sesac.spring.jpa.controller;

import com.sesac.sesac.spring.jpa.DTO.StudentDTO;
import com.sesac.sesac.spring.jpa.entity.Student;
import com.sesac.sesac.spring.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
//    @GetMapping("/count")
//    public int getCountAll(){}
    @Autowired
    StudentService studentService;


    // 1. 전체 검색 ( select * from student )
    @GetMapping("/all")
    public List<StudentDTO> getAll(){
        // student의 목록을 전부 가져와서 보여주는 API
        return studentService.getStudentAll();
    }

    // 2. 삽입 ( insert into ~~~ )
    @GetMapping("/insert") // /student/insert?name=이름
    public String insertStudent(@RequestParam String name,
                                @RequestParam String nickname,
                                @RequestParam Student.LoginType type) {
         return studentService.insertStudent(name, nickname, type);
         // 이름, 닉네임, login_type
    }

    // 3. 조건에 따른 검색 ( select * from student name= I り
    //http://localhost:8080/student/search/name?name=%EC%9D%B4%EB%A6%84
    @GetMapping("/search/name") // /search/name?name= 이름
    public String searchStudentByName (@RequestParam String name){
        return studentService.searchStudentByName(name);
    }
    // 4. 조건에 따른 검색 (2) select * from student where id =
    @GetMapping("/search/id") // /search/name?name= 이름
    public String searchStudentById (@RequestParam int id){
        return studentService.searchStudentById(id);
    }

    // 실습 1
    @GetMapping("/count/nickname") //
    public String countStudentByNickname (@RequestParam String nickname){
        return studentService.countStudentByNickname(nickname);
    }

    @GetMapping("/update")
    public String updateStudentName(@RequestParam int id, @RequestParam String name) {
        return studentService.updateStudentName(id, name);
    }


//    @GetMapping("/search")
//    public ? getSearch(@RequestBody int id){}

    // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
}
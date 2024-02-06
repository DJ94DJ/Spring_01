package com.sesac.sesac.spring.study.controller.controller;

import com.sesac.sesac.spring.study.controller.dto.UserDTO;
import com.sesac.sesac.spring.study.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    // C, R
    // Mybatis 수업 controller
    // 1. Table 생성 완료 ( user )
    // 2. domain 만들기 ( domain/user )
    // 3. mapper 만들기
    // 4. service 2=71
    // 5. controller
    // * 이 과정은 반대로 만드는 것.

    @Autowired
    UserService userService;
    @GetMapping("/all") // 실제 경로 /user/all
    public List<UserDTO> getUser(){
        List<UserDTO> result = userService.retrieveAll();
        return result;
    } // []

    @GetMapping("/user") // 실제 경로 /user/user
    public String getUserInsert(
        @RequestParam String name,
        @RequestParam String nickname) {
          userService.createUser(name, nickname);
          return "Success";
        }

    @GetMapping("/update") // 실제 경로 /user/update
    public String updateUser(
            @RequestParam int id,
            @RequestParam String nickname) {
        userService.updateUser(id, nickname);
        return "Update Success";
    }

    @GetMapping("/delete") // 실제 경로 /user/update
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "Delete Success";
    }

    }




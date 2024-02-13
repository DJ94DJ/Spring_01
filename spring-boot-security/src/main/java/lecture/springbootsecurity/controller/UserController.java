package lecture.springbootsecurity.controller;

import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import lecture.springbootsecurity.dto.UserDTO;
import lecture.springbootsecurity.entity.UserEntity;
import lecture.springbootsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j // 로그 관련 메소드를 편리하게 사용할 수 있음.
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("")
    public String getAuth() {
        return "GET /auth";
    }

    @PostMapping("/signup")
    // ? << 와일드 카드 : 무슨 값이 오든지 상관이 없단 뜻 (어떤 값을 Body에 담을지 모름)
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){

        try { //오류 처리
//       1) userDto로 entity를 생성
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .build();

            UserEntity responseUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .email(responseUser.getEmail())
                    .username(responseUser.getUsername())
                    .id(responseUser.getId())
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //@순서 흐름 물어보기
    // 엔티티 - DTO - 레포지토리 - 서비스 - 컨트롤러

    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(HttpSession session, @RequestBody UserDTO userDTO){
        try{

            UserEntity user = userService.login(userDTO.getEmail(), userDTO.getPassword());

            if(user == null){
                throw new RuntimeException("login failed");
            }

//        응답 객체를 만들기위해서 DTO객체를 만든거임
            UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .username(user.getUsername())
                    .id(user.getId())
                    .build();

            //log.info();
            //log.error();
            //log.warn();
            log.warn("session id {}", session.getId());
            session.setAttribute("userId", user.getId());

            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}


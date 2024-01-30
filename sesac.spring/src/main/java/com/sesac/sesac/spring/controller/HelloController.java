package com.sesac.sesac.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// spring에게 컨트롤러 import 하는 방법임.
// @Controller : 해당 클래스가 컨트롤러의 역할을 하는 클래스인것을 스프핑 컨테이너에게 알려줌
public class HelloController {

    @GetMapping("/hi")
    // URL 을 매핑시켜주는 친구
    // 클라이언트가 /hi 라는 경로로 GET METHOD로
    // 접근한다면 아래 메서드를 실행시켜라
    public String getHi(Model model) {
        // Model : Controller 안의 메서드가 파라미터로 받을 수 있는 객체 중 하나

        // Model 안에 정보를 담아서 view로 전달
        // IoC : 개발자가 직접 model을 생성 X
        model.addAttribute(  "name", "코딩온" ) ;
        model.addAttribute(  "name2", "<strong>홍길동</strong>" ) ;
        model.addAttribute(  "key", "값" ) ;
        model.addAttribute(  "age1", 17 ) ;
        model.addAttribute(  "age2", 39 ) ;

        String[] items = {"a","b","c","d","e"};
        model.addAttribute( "item1" , items);

        char[] alphabetArray = new char[26];
        char alphabet = 'A';
        for (int i = 0; i < 26; i++) {
            alphabetArray[i] = alphabet;
            alphabet++;
        }
        model.addAttribute( "item1" , items);
        model.addAttribute("item2", alphabetArray);



        return "hi"; // 템플릿 파일의 이름을 불러오는 것.
        // res.render("hi")
        // res.render("hi" / {name: I 홍길동'}) -> X



    }

}

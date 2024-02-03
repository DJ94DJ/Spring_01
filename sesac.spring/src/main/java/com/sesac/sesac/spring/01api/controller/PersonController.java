package com.sesac.sesac.spring.api.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @GetMapping("/people")

    public String getPeople(Model model) {
        List<Person> people = new ArrayList<>();

        Person person1 = new Person("Alice", 20);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Charlie", 30);
        Person person4 = new Person("David", 35);
        Person person5 = new Person("Eve", 40);

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

        // 모델에 데이터 리스트 추가
        model.addAttribute("people", people);



        return "people";
    }
}

@Getter
@Setter
class Person {
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}



package com.sesac.sesac.spring.jpa.service;

import com.sesac.sesac.spring.jpa.DTO.StudentDTO;
import com.sesac.sesac.spring.jpa.entity.Student;
import com.sesac.sesac.spring.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // 이 코드가 직접 SQL문을 만들어준다!
    public List<StudentDTO> getStudentAll(){
        List<Student> result = studentRepository.findAll(); // 전체검색 alt + Enter로 임포트 시키자
        List<StudentDTO> students = new ArrayList<>();

        for ( Student student: result) {
            // Builder : 객체를 만들 때 순서에 의해 생기는 문제, 명시적이지 못한 문제를 해결하기 위해 나온 방법
            // 생성자 주입 : 여러 필드 존재시 순서 엄수
            // setter 를 통한 주입 : 필드 개수만큼 매번 메소드를 만들어줘야 한다.
            StudentDTO studentDTO = StudentDTO.builder()
                    .name(student.getName())
                    .nickname(student.getNickname())
                    .build();
            students.add(studentDTO);

            //StudentDTO studentDTO = new StudentDTO();
            // studentDTO.setName("이름").... 이런 것과 같음
        }
        return students;
    }
}

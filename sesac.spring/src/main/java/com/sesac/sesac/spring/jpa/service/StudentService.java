package com.sesac.sesac.spring.jpa.service;

import com.sesac.sesac.spring.jpa.DTO.StudentDTO;
import com.sesac.sesac.spring.jpa.entity.Student;
import com.sesac.sesac.spring.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // 이 코드가 직접 SQL문을 만들어준다!
    public List<StudentDTO> getStudentAll() {
        List<Student> result = studentRepository.findAll(); // 전체검색 alt + Enter로 임포트 시키자
        List<StudentDTO> students = new ArrayList<>();

        for (Student student : result) {
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

    public String insertStudent(String name, String nickname, Student.LoginType type) {
        // 받아온 데이터로 repository의 save 메소드 호출
        Student student = Student.builder().name(name).nickname(nickname).type(type).build();
        Student newStudent = studentRepository.save(student);
        // newStudent : save를 한 후 반환되는 Entity 객체

        return newStudent.getId() + newStudent.getName();
    }

    public String searchStudentByName(String name) {
        List<Student> student = studentRepository.findByName(name);
//        return "id는 " + student.getId() + " 입니다.";
        return "해당하는 이름의 사용자는 " + student.size() + "명입니다.";
    }

    public String searchStudentById(int id) {
//        Optional<Student> student = studentRepository

        // Student student = student Repository.findById(id);
        // if ( student != null )
        // Optional<List<T>>
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("사용자가 없다!!!!"));
        return student.getName();
//        if (student.isPresent()) {
//            // ispresent 객체의 여부를 불린으로 반환
//            return student.get().getName(); // get으로 한번 꺼내놓아야함. Optional 에 담긴 객체 반환
//        }
//        // Optional 이 생기면서 새로운 설정이 필요하다. java 8부터 등장
//        // null 일수도 있는 객체를 감싸는 wrapper 클래스
//    }
    }
    public String countStudentByNickname(String nickname)  {
        long count = studentRepository.countByNickname(nickname);
        return "해당하는 닉네임의 사용자는 " + count + "명입니다.";
    }

    public String updateStudentName(int id, String name) {
        // save(T) : 새로운 entity를 insert or 기존 entity를 update
        // T의 기본값(pk) 의 상태에 따라 다르게 동작
        //- pk값이 존재하는 경우 : pk와 연결된 etity를 update
        //- pk값이 없는 경우 : 새로운 entity를 insert

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id를 가진 학생이 없습니다."));
//        student.setName(name);
//        return studentRepository.save(student);
        Student modifiedStudent =
                Student.builder()
                        .id(id).name(name).nickname(student.getNickname())
                        .type(student.getType()).build();

        studentRepository.save(modifiedStudent);
        return "update Sucess";
    }

}


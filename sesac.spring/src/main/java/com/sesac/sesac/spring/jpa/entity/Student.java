package com.sesac.sesac.spring.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
//import lombok.Setter;
import lombok.NoArgsConstructor;
// : 데이터베이스의 필드와 변수의 연관관계가 정의된 친구
// : db 테이블에 대응되는 하나의 클래스

@Entity  // class student() {} // 빈 객체(생성자)가 필수로 필요함.
@NoArgsConstructor // 빈거 만들어주는거
@Getter
//@Setter
@Builder // 그러나 빌더는 필드가 전체 다 들어 있는 생성자가 필요함. // 서로 충돌함. 그래서 누가 뭐쓸지 알려줘야 오류가 안남! 500
@AllArgsConstructor // 다들어있는 생성자.
@Table(name= "STUDENT")
// 데이터베이스 필드의 변수와 연관관계가 정의된 개체
// DB 테이블에 대응되는 하나의 클래스
public class Student {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;
    // id int primary key auto_increment
    // SEQUENCE : 새로운 오브젝트를 만들어서 id를 부여하는 방법 (mysql x)
    // TABLE : 시퀸스 전략을 흉내낸 전략 -> 모든 DBMS에서 사용가능 (성능은 떨어짐)

    @Column (name = "name", nullable = false, length = 20)
    private String name;
    // name varchar (20) not null,
    @Column(columnDefinition = "TEXT")
    private  String nickname;

    // enum
    @Column
    @Enumerated(EnumType.STRING)
    private LoginType type;



    public enum LoginType {
        GOOGLE, KAKAO
        //	id 'org.springframework.boot' version '3.1.2' 스프링프레임워크 버전이 3.1 이상이어야 이넘이 작동한 한다!!
    }

   // mybatis - V mapper
   // jpa(orm) -> repository
    // Repository : Entity 에 의해서 만들어진 테이블에 접근하는 메소드들을 정의해놓은 인터페이스
    // CRUD를 하기 위한 메소드를 정의하는 계층 = Repository
   // JpaRepository 제공 ->
    //        - 전체조회
    //        - 아이디로 조회
    //        - 전체삭제



}

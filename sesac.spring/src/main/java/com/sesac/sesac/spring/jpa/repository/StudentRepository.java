package com.sesac.sesac.spring.jpa.repository;
import com.sesac.sesac.spring.jpa.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // 1. jpa 의 기본 규칙을 따르는 방법
    // findBy 컬럼명
    List<Student> findByName(String name); // primary key, unique key

    List<Student> findByNameAndNickname (String name,String nickname);
    //이름과 닉네임이 모두 일치하는 친구를 검색
    List<Student> findByNameOrNickname (String name, String nickname);
    //이름이 일치하거나 닉네임이 일치하는 경우

    // findByAgeGreaterThanEqual(int age) // age가 값보다 크거나 같은 경우

    //2. 직접 쿼리 연결
//    @Query("select s from Student s where s.name = :a")
    @Query(nativeQuery = true, value = "select * from Student where name= :name")
    List<Student>  findTest(@Param("name") String name);

    // 실습

    long countByNickname(String nickname);

    Optional<Student> findById(int id);


}

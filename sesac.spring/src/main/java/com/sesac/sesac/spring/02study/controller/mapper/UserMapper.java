package com.sesac.sesac.spring.study.controller.mapper;
import com.sesac.sesac.spring.study.controller.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


import java.util.List;

//mapper 는 interface로 정의가 되어야 됨 (class 아님)
@Mapper
public interface UserMapper {
    //    (sql 문 정의 )or (xml 파일을 읽거나)
    //    List<User> retreiveAll();

//    @Select()
    // xml 파일을 읽어서 찾겠다.
    List<User> retrieveAll();

    @Insert("insert into user(name, nickname) values(#{name} , #{nickname})")
    void createUser(
            String name, String nickname);

    // 업데이트 기능
    @Update("UPDATE user SET nickname = #{nickname} WHERE id = #{id}")
    void updateUser(int id, String nickname);

    // 삭제 기능
    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(int id);
}
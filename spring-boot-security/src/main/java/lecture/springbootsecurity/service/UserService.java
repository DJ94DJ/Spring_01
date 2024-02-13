package lecture.springbootsecurity.service;

import lecture.springbootsecurity.entity.UserEntity;
import lecture.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserEntity create(UserEntity userEntity){ // 회원가입할떄 사용하는 메소드
        if(userEntity == null){
            throw new RuntimeException("entity null");
        }

        //중복 이메일 불가
        String email = userEntity.getEmail();
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("이미 존재하는 이메일");
        }

        return userRepository.save(userEntity); // 가입한 이메일 세이브하는하는곳
    }

// *암호화 전
//    public UserEntity login(String email, String password) {
//        return userRepository.findByEmailAndPassword(email, password);
//    }

// *암호화 후
    public UserEntity login(String email, String password) {
        UserEntity searchUser = userRepository.findByEmail(email);

        if(searchUser != null && passwordEncoder.matches(password,searchUser.getPassword())) {
            return searchUser;
        }
            // 앞에는 미암호환된 암호, 뒤에는 암호된된 암호
        return null;
    }
}

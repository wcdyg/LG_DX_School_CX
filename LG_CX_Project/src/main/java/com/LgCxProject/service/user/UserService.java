package com.LgCxProject.service.user;

import com.LgCxProject.domain.user.User;
import com.LgCxProject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // 사용자 로그인 기능 - 입력한 아이디와 비밀번호가 DB에 있는지 확인하는 기능
    public User login(String userId, String password) throws RuntimeException {

        User user = userRepository.findUserByIdAndPassword(userId, password);
        return user;
    }

    // 사용자 회원가입
    public boolean signup(User user) {
        // 아이디와 패스워드는 최대 10자리만 입력
        if(user.getUserId().length() > 10){
            return false;
        }

        if(user.getPassword().length() > 10){
            return false;
        }

        if (isUserAlreadyExists(user.getUserId())) {
            System.out.println("회원가입 실패: 이미 존재하는 아이디입니다.");
            return false;
        }

        userRepository.save(user);
        return true;
    }

    // 아이디 중복 검사
    public boolean isUserAlreadyExists(String userId) {
        return userRepository.findByUserId(userId).isPresent();
        // 값이 있으면 값, 아니면 null
    }

}

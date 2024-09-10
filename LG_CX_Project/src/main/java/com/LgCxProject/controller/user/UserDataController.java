package com.LgCxProject.controller.user;

import com.LgCxProject.domain.user.User;
import com.LgCxProject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDataController {

    @Autowired
    UserService userService;

//    @GetMapping("/checkUserId")
//    public ResponseEntity<Boolean> checkUserId(@RequestParam(name = "userId") String userId) {
//        boolean exists = userService.isUserAlreadyExists(userId);
//        return ResponseEntity.ok(exists);  // true 또는 false 반환

    @GetMapping("/checkUserId")
    public boolean isUserAlreadyExist(@RequestParam(name = "userId") String userId) {
        System.out.println("[아이디 중복검사] 입력받은 아이디 : " + userId);
        return userService.isUserAlreadyExists(userId);

    }
}

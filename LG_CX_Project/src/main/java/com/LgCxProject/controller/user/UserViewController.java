package com.LgCxProject.controller.user;

import com.LgCxProject.domain.user.User;
import com.LgCxProject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserViewController {

    @Autowired
    UserService userService;

    // 로그인 버튼을 누르면 이뤄지는 로직
    @PostMapping("/login-process")
    public String loginCheck(@RequestParam(name="userId") String userId,
                             @RequestParam(name="password") String password,
                             Model model){

        boolean isValidUser = userService.login(userId,password);
        // login 서비스의 결과 값에 따라 다른 화면 반환
        //로그인 성공
        if(isValidUser){
            return "home";
        }
        //로그인 실패
        model.addAttribute("error", "존재하지 않는 사용자입니다.");
        return "user/login";
    }

    // 회원가입 버튼을 누르면 회원가입 화면을 반환
    @GetMapping("/user/signup")
    public String signup() {
        return "user/signup";
    }

    // 회원가입 처리에 대한 화면 전환
    @PostMapping("/signup-process")
    public String signupProcess(@ModelAttribute User user, Model model) {

        boolean isValidSignUp = userService.signup(user);
        System.out.println(isValidSignUp);

        if(isValidSignUp){
            System.out.println("회원가입성공");
            return "redirect:/user/login";
        }
        System.out.println("회원가입실패");
        model.addAttribute("error","회원가입 실패");
        return "/user/signup";
    }

    //추가 버튼 누르면 바코드 스캔 화면으로 반환

    // 스캔 버튼 누르면 영양제 등록 페이지로 반환

    // 등록 완료 버튼을




}

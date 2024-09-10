package com.LgCxProject.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {

    //  홈 화면
    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    //  로그인 화면
    @GetMapping({"/", "/user/login"})
    public String login(){
        return "/user/login";
    }

}

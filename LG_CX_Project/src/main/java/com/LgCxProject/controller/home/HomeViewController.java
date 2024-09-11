package com.LgCxProject.controller.home;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {

    //  홈 화면
    @GetMapping("/home")
    public String home(HttpSession session , Model model) {
        if(session.getAttribute("username") == null) {
            return "/user/login";
        }
        model.addAttribute("username" , session.getAttribute("username"));
        model.addAttribute("userId", session.getAttribute("userId"));

        //  기기 정보 보여주기?!
//        List<Review> reviews = reviewService.findAllReviews();
//        model.addAttribute("reviews", reviews);

        return "/home";
    }

}

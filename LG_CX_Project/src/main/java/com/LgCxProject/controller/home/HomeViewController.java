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

    //  배너 선택시 (디스펜서) 저장소 정보 보기
    @GetMapping("/storage/storage")
    public String storage(HttpSession session , Model model) {
        if(session.getAttribute("username") == null) {
            return "/user/login";
        }
        model.addAttribute("headerText","보관함 6번이다");
        model.addAttribute("userId", session.getAttribute("userId"));

        model.addAttribute("headerText", "디스펜서 화면(영양제 등록 전)");
        model.addAttribute("option1Text", "보관함 5에 영양제 추가하는 버튼");
        model.addAttribute("option2Text", "보관함 6에 영양제 추가하는 버튼");

        return "/storage/storage";
    }




}

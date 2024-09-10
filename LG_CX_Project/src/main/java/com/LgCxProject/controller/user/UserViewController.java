package com.LgCxProject.controller.user;

import com.LgCxProject.domain.user.User;
import com.LgCxProject.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserViewController {

    @Autowired
    UserService userService;

    //  로그인 화면
    @GetMapping({"/", "/user/login"})
    public String login(HttpSession session , RedirectAttributes redirectAttributes){
        //세션 여부 확인 -> 세션 없으면 login, 있으면 main
        if(session.getAttribute("username") == null) {
            return "/user/login";
        }
        redirectAttributes.addFlashAttribute("username", session.getAttribute("username"));
        redirectAttributes.addFlashAttribute("userId", session.getAttribute("userId"));
        return "redirect:/home";
}

    // 로그인 버튼을 누르면 이뤄지는 로직
    @PostMapping("/login-process")
    public String loginCheck(@RequestParam(name="userId") String userId,
                             @RequestParam(name="password") String password,
                             Model model, HttpSession session,
                             RedirectAttributes redirectAttributes){

        User user = userService.login(userId,password);

        if(user != null) {
            model.addAttribute("username", user.getName());
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getName());

//            List<Review> reviews = reviewService.findAllReviews();
//            redirectAttributes.addFlashAttribute("reviews", reviews);
//            // 리다이렉트할 때 이 속성도 같이 보낸다
//            // 원래는 리다이렉트하면 속성 사라짐

            return "redirect:/home";
        }else{
            //로그인 실패
            model.addAttribute("error", "존재하지 않는 사용자입니다.");
            return "user/login";
        }
    }

    // 로그아웃하기
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
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

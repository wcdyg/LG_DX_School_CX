package com.LgCxProject.controller.home;

import com.LgCxProject.domain.storage.Storage;
import com.LgCxProject.domain.storage.UserStorageInfo;
import com.LgCxProject.service.storage.StorageService;
import com.LgCxProject.service.storage.UserStorageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeViewController {

    @Autowired
    UserStorageService userStorageService;

    @Autowired
    StorageService storageService;

    //  홈 화면
    @GetMapping("/home")
    public String home(HttpSession session , Model model) {
        if(session.getAttribute("username") == null) {
            return "/user/login";
        }
        model.addAttribute("username" , session.getAttribute("username"));
        model.addAttribute("userId", session.getAttribute("userId"));

        return "/home";
    }

}

package com.LgCxProject.controller.storage;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StorageViewController {

    // StorageView에서 보관함 추가 버튼을 누를 때, 보관함 번호를 전달받아 처리
    //  배너 선택시 (디스펜서) 저장소 정보 보기
    @GetMapping("/storage/storage")
    public String storage(HttpSession session , Model model) {

        if(session.getAttribute("username") == null) {
            return "/user/login";
        }

        // 사용자 ID를 가져옴
        String userId = (String) session.getAttribute("userId");

        // 색상 결정
        String container1Color = determineColorForUser(userId, 1);
        String container2Color = determineColorForUser(userId, 2);
        String container3Color = determineColorForUser(userId, 3);
        String container4Color = determineColorForUser(userId, 4);
        String container5Color = determineColorForUser(userId, 5);
        String container6Color = determineColorForUser(userId, 6);

        model.addAttribute("container1", "오메가3");
        model.addAttribute("container2", "종합비타민");
        model.addAttribute("container3", "보관함3");
        model.addAttribute("container4", "보관함4");
        model.addAttribute("container5Number", "5");
        model.addAttribute("container6Number", "6");
        model.addAttribute("container1SupplementCount", "27");
        model.addAttribute("container2SupplementCount", "13");
        model.addAttribute("container3SupplementCount", "5");
        model.addAttribute("container4SupplementCount", "30");

        // 색상 정보를 모델에 추가
        model.addAttribute("container1Color", container1Color);
        model.addAttribute("container2Color", container2Color);
        model.addAttribute("container3Color", container3Color);
        model.addAttribute("container4Color", container4Color);
        model.addAttribute("container5Color", container5Color);
        model.addAttribute("container6Color", container6Color);

        return "/storage/storage";
    }

    @GetMapping("/scan")
    public String scanpage() {
        return "/supplements/scan";
    }

    @GetMapping("/supplements/add")
    public String addpage() {
        return "/supplements/add";
    }

    @GetMapping("/supplements/scan")
    public String addscanpage(@RequestParam("container") int container, Model model) {
        model.addAttribute("container", container);
        return "/supplements/scan";
    }

    // 사용자 ID와 보관함 번호에 따라 색상을 결정하는 메서드
    private String determineColorForUser(String userId, int containerNumber) {
        switch (userId) {
            case "user1":
                return containerNumber % 2 == 0 ? "#ff0000" : "#00ff00"; // 빨강, 초록
            case "user2":
                return containerNumber % 2 == 0 ? "#0000ff" : "#ffff00"; // 파랑, 노랑
            default:
                return "#b09fbf"; // 기본 색상
        }
    }
}

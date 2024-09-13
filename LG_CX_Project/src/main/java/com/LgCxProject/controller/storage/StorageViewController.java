package com.LgCxProject.controller.storage;

import com.LgCxProject.domain.user.User;
import com.LgCxProject.repository.user.UserRepository;
import com.LgCxProject.service.storage.StorageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class StorageViewController {

    @Autowired
    StorageService storageService;
    @Autowired
    UserRepository userRepository;

    //추가 버튼 누르면 바코드 스캔 화면으로 반환 - 보관함 번호를 가져와야 한다!

    // StorageView에서 보관함 추가 버튼을 누를 때, 보관함 번호를 전달받아 처리

    @GetMapping("/storage/storage")
    public String storage(HttpSession session , Model model) {

        if(session.getAttribute("username") == null) {
            return "/user/login";
        }

        // 사용자 ID를 가져옴
        String userId = (String) session.getAttribute("userId");

        // 환영 메세지 이름 모델에 추가
        Optional<User> user = userRepository.findByUserId(userId);
        model.addAttribute("username",user.get().getName());

        // 다음 페이지로 넘기는 숫자
        model.addAttribute("container1Number", "1");
        model.addAttribute("container2Number", "2");
        model.addAttribute("container3Number", "3");
        model.addAttribute("container4Number", "4");
        model.addAttribute("container5Number", "5");
        model.addAttribute("container6Number", "6");

        // 보관함 사용자 이름 모델에 추가
//        model.addAttribute("container1username", "김수연");
        HashMap<String, List<String>> containerUserName= storageService.containerUserName();
        for(String key: containerUserName.keySet()){
            model.addAttribute(key,String.join("<br>",containerUserName.get(key)));
        }

        // 보관함 별 재고 가져오기
//        model.addAttribute("container1SupplementCount", "27");
        HashMap<String ,Integer> containerSupplementCount = storageService.containerSupplementCount();
        for(String key: containerSupplementCount.keySet()){
            model.addAttribute(key,containerSupplementCount.get(key));
        }

        // 보관함 별 영양제 용량 가져오기
//        model.addAttribute("container1SupplementCapacity", "50");
        HashMap<String, Integer> containerSupplementCapacity = storageService.containerSupplementCapacity();
        for(String key: containerSupplementCapacity.keySet()){
            model.addAttribute(key,containerSupplementCapacity.get(key));
        }

        // 보관함 별 영양제 이름 가져오기
//        model.addAttribute("container1", "");
        HashMap<String ,String> containerSupplementName = storageService.containerSupplementName();
        for(String key: containerSupplementName.keySet()){
            model.addAttribute(key,containerSupplementName.get(key));
        }

        // 보관함 별 색상 설정하기
        HashMap<String ,String> containerColor = storageService.containerColor(userId);
        for(String key: containerColor.keySet()){
            model.addAttribute(key,containerColor.get(key));
        }

        return "/storage/storage";
    }

    // 컨테이너 값을 세션에 저장
    @PostMapping("/supplements/scan")
    public String scan(@RequestParam("container") int container, HttpSession session) {
        session.setAttribute("container", container); // 세션에 container 값 저장
        return "/supplements/scan"; // 다음 페이지로 이동
    }


}

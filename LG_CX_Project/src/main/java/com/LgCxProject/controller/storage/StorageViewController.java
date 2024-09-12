package com.LgCxProject.controller.storage;

import com.LgCxProject.domain.user.User;
import com.LgCxProject.repository.user.UserRepository;
import com.LgCxProject.service.storage.StorageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        // 보관함 사용자 이름 모델에 추가
        HashMap<String, List<String>> containerUserName= storageService.containerUserName();
        for(String key: containerUserName.keySet()){
            model.addAttribute(key,String.join("<br>",containerUserName.get(key)));
        }

        // 보관함 별 재고 가져오기
        HashMap<String ,Integer> containerSupplementCount = storageService.containerSupplementCount();
        for(String key: containerSupplementCount.keySet()){
            model.addAttribute(key,containerSupplementCount.get(key).toString());
        }

        // 보관함 별 영양제 용량 가져오기
        HashMap<String, Integer> containerSupplementCapacity = storageService.containerSupplementCapacity();
        for(String key: containerSupplementCapacity.keySet()){
            model.addAttribute(key,containerSupplementCapacity.get(key).toString());
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


        model.addAttribute("container5Number", "5");
        model.addAttribute("container6Number", "6");


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

}

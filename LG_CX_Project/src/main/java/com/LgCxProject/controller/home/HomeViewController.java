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
<<<<<<< HEAD
        String userId = (String) session.getAttribute("userId");

        List<Storage> storageInfoList = storageService.findAllStorage();

        System.out.println(userId);

        List<UserStorageInfo> userStorageInfoList = userStorageService.findStorageByUserId(userId);
        // 해당 storage_id로 찾아야함 그 리스트 안에서
//        userStorageInfoList.get(0).getStorage_id()

        model.addAttribute("optionText1", userStorageInfoList.get(0).getStorageId() +
                " 번의 재고량 " + storageInfoList.get(0).getStock());
        model.addAttribute("optionText2", userStorageInfoList.get(1).getStorageId() +
                " 번의 재고량 " + storageInfoList.get(1).getStock());
        if user -== colvar = blue

        for(int i = 0; i < storageInfoList.size(); i++){
            String stockNum = "stockNum%d".formatted(i);
            String stock = "stock%d".formatted(i);

            model.addAttribute(stockNum, storageInfoList.get(i).getStorageId());
            model.addAttribute(stock, storageInfoList.get(i).getStock());
        }

//        if (!userStorageInfoList.isEmpty()){
//        }

=======
        model.addAttribute("headerText","보관함 6번이다");
        model.addAttribute("userId", session.getAttribute("userId"));

        model.addAttribute("headerText", "디스펜서 화면(영양제 등록 전)");
        model.addAttribute("option1Text", "보관함 5에 영양제 추가하는 버튼");
        model.addAttribute("option2Text", "보관함 6에 영양제 추가하는 버튼");

>>>>>>> 7a88bb3af641395ca8e72c1bc0703399579d4b27
        return "/storage/storage";
    }


    @GetMapping("/scan")
    public String scanpage() {

        return "/supplements/scan";
    }



}

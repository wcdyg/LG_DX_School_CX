package com.LgCxProject.controller.storage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StorageViewController {

    //추가 버튼 누르면 바코드 스캔 화면으로 반환 - 보관함 번호를 가져와야 한다!

    // StorageView에서 보관함 추가 버튼을 누를 때, 보관함 번호를 전달받아 처리
    @GetMapping("/dispenser")
    public String dispenserView(Model model) {
        // 페이지에 필요한 데이터 설정 (예시: 보관함 번호를 동적으로 설정)
        model.addAttribute("headerText", "디스펜서 화면(영양제 등록 전)");
        model.addAttribute("option1Text", "보관함 5에 영양제 추가하는 버튼");
        model.addAttribute("option2Text", "보관함 6에 영양제 추가하는 버튼");

        return "storage"; // storage.html 반환
    }

    @GetMapping("/scan")
    public String scanpage(@RequestParam("storage") int storage ,
                           Model model) {
        model.addAttribute("storage" , storage);
        return "/supplements/scan";
    }

    @GetMapping("/supplements/add")
    public String addpage(@RequestParam("storage") int storage ,
                          Model model) {

        model.addAttribute("storageNumber" , storage);

        return "/supplements/add";
    }


}


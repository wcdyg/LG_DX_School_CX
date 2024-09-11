package com.LgCxProject.controller.storage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StorageViewController {

    //추가 버튼 누르면 바코드 스캔 화면으로 반환 - 보관함 번호를 가져와야 한다!

    // StorageView에서 보관함 추가 버튼을 누를 때, 보관함 번호를 전달받아 처리

    @GetMapping("/scan")
    public String scanpage() {

        return "/supplements/scan";
    }

    @GetMapping("/supplements/add")
    public String addpage() {

        return "/supplements/add";
    }

}


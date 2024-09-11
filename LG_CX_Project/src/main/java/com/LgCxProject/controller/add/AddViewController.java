package com.LgCxProject.controller.add;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddViewController {

    @GetMapping("/storage/newstorage")
    public String newstoragepage() {
        return "/storage/newstorage";
    }

}

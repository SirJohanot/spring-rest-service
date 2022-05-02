package com.springfeatures.springrestservice.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/api/travel")
    public String displayForm() {
        return "index";
    }

}

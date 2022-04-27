package com.springfeatures.springrestservice.api;

import com.springfeatures.springrestservice.model.TimeToCross;
import com.springfeatures.springrestservice.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @GetMapping("/api/travel")
    public String displayForm(){
        return "index";
    }

}

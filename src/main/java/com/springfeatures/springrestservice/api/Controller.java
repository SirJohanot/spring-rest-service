package com.springfeatures.springrestservice.api;

import com.springfeatures.springrestservice.model.TimeToCross;
import com.springfeatures.springrestservice.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@RequestMapping("api/travel")
@org.springframework.stereotype.Controller
public class Controller {

    private final TravelService travelService;

    @Autowired
    public Controller(@Qualifier("travelServiceImpl")TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping
    public String displayForm(){
        return "index";
    }

    @GetMapping(params = {"distance","speed"})
    @ResponseBody
    public TimeToCross calculateTravelTime(@RequestParam int distance, @RequestParam int speed){
        return travelService.calculateTimeToCross(distance, speed);
    }
}

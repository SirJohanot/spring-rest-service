package com.springfeatures.springrestservice.api;

import com.springfeatures.springrestservice.model.TimeToCross;
import com.springfeatures.springrestservice.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RequestMapping("api/travel")
@RestController
public class Controller {

    private final TravelService travelService;

    @Autowired
    public Controller(@Qualifier("travelServiceImpl")TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping(value = "{distance}{speed}")
    @ResponseBody
    public TimeToCross calculateTravelTime(@PathVariable("distance") int distance, @PathVariable("speed") int speed){
        return travelService.calculateTimeToCross(distance, speed);
    }
}

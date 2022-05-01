package com.springfeatures.springrestservice.api;

import com.springfeatures.springrestservice.exception.InvalidTravelParametersException;
import com.springfeatures.springrestservice.model.TimeToCross;
import com.springfeatures.springrestservice.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("travelController")
@RequestMapping("/api/travel")
public class TravelController {

    private final TravelService travelService;

    @Autowired
    public TravelController(@Qualifier("travelServiceImpl") TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping(params = {"distance", "speed"})
    public TimeToCross calculateTravelTime(@RequestParam int distance, @RequestParam int speed) throws InvalidTravelParametersException {
        return travelService.calculateTimeToCross(distance, speed);
    }

}

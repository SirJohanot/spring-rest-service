package com.springfeatures.springrestservice.api;

import com.springfeatures.springrestservice.exception.InvalidTravelParametersException;
import com.springfeatures.springrestservice.model.TravelResponse;
import com.springfeatures.springrestservice.service.TravelRequestCounter;
import com.springfeatures.springrestservice.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/travel")
public class TravelController {

    private final TravelService travelService;
    private final TravelRequestCounter travelRequestCounter;

    @Autowired
    public TravelController(@Qualifier("travelServiceImpl") TravelService travelService, TravelRequestCounter travelRequestCounter) {
        this.travelService = travelService;
        this.travelRequestCounter = travelRequestCounter;
    }

    @GetMapping(params = {"distance", "speed"})
    public TravelResponse calculateTravelTime(@RequestParam int distance, @RequestParam int speed) throws InvalidTravelParametersException {
        travelRequestCounter.increment();
        int responseNumber = travelRequestCounter.getRequestsMadeNumber();
        int time = travelService.calculateTimeToCross(distance, speed);
        return new TravelResponse(time, responseNumber);
    }

}

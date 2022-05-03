package com.springfeatures.springrestservice.api;

import com.springfeatures.springrestservice.exception.InvalidTravelParametersException;
import com.springfeatures.springrestservice.model.BulkTravelResponse;
import com.springfeatures.springrestservice.model.TravelRequest;
import com.springfeatures.springrestservice.model.TravelResponse;
import com.springfeatures.springrestservice.service.TravelRequestCounter;
import com.springfeatures.springrestservice.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public BulkTravelResponse bulkCalculateTravelTimes(@RequestBody List<TravelRequest> travelRequestList) throws InvalidTravelParametersException {
        travelRequestCounter.increment();
        int responseNumber = travelRequestCounter.getRequestsMadeNumber();
        List<Integer> timeList = travelService.bulkCalculateTimesToCross(travelRequestList);
        return new BulkTravelResponse(timeList, responseNumber);
    }
}

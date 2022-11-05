package com.patiun.springrestservice.api;

import com.patiun.springrestservice.exception.InvalidTravelParametersException;
import com.patiun.springrestservice.model.BulkTravelResponse;
import com.patiun.springrestservice.model.TravelRequest;
import com.patiun.springrestservice.model.TravelResponse;
import com.patiun.springrestservice.service.TravelRequestCounterService;
import com.patiun.springrestservice.service.TravelService;
import com.patiun.springrestservice.service.TravelStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel")
public class TravelController {

    private final TravelService travelService;
    private final TravelRequestCounterService travelRequestCounterService;
    private final TravelStatisticsService travelStatisticsService;

    @Autowired
    public TravelController(@Qualifier("travelServiceImpl") TravelService travelService, TravelRequestCounterService travelRequestCounterService, @Qualifier("travelStatisticsServiceImpl") TravelStatisticsService travelStatisticsService) {
        this.travelService = travelService;
        this.travelRequestCounterService = travelRequestCounterService;
        this.travelStatisticsService = travelStatisticsService;
    }

    @GetMapping(params = {"distance", "speed"})
    public TravelResponse calculateTravelTime(@RequestParam int distance, @RequestParam int speed) throws InvalidTravelParametersException {
        travelRequestCounterService.increment();
        int responseNumber = travelRequestCounterService.getRequestsMadeNumber();
        int time = travelService.calculateTimeToCross(distance, speed);
        return new TravelResponse(time, responseNumber);
    }

    @PostMapping
    public BulkTravelResponse bulkCalculateTravelTimes(@RequestBody List<TravelRequest> travelRequestList) throws InvalidTravelParametersException {
        travelRequestCounterService.increment();
        int responseNumber = travelRequestCounterService.getRequestsMadeNumber();
        List<Integer> timeList = travelService.bulkCalculateTimesToCross(travelRequestList);
        return travelStatisticsService.gatherStatisticsAndBuildTravelResponse(timeList, responseNumber, travelRequestList);
    }
}

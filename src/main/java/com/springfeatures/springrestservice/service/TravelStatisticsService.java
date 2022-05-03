package com.springfeatures.springrestservice.service;

import com.springfeatures.springrestservice.model.BulkTravelResponse;
import com.springfeatures.springrestservice.model.TravelRequest;

import java.util.List;

public interface TravelStatisticsService {

    BulkTravelResponse gatherStatisticsAndBuildTravelResponse(List<Integer> calculatedTravelTimes, int responseNumber, List<TravelRequest> travelRequestList);
}

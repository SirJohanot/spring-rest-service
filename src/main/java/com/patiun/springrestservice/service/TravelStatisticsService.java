package com.patiun.springrestservice.service;

import com.patiun.springrestservice.model.BulkTravelResponse;
import com.patiun.springrestservice.model.TravelRequest;

import java.util.List;

public interface TravelStatisticsService {

    BulkTravelResponse gatherStatisticsAndBuildTravelResponse(List<Integer> calculatedTravelTimes, int responseNumber, List<TravelRequest> travelRequestList);
}

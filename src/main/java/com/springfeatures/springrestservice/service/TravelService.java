package com.springfeatures.springrestservice.service;

import com.springfeatures.springrestservice.exception.InvalidTravelParametersException;
import com.springfeatures.springrestservice.model.TravelRequest;

import java.util.List;

public interface TravelService {

    int calculateTimeToCross(int distance, int speed) throws InvalidTravelParametersException;

    List<Integer> bulkCalculateTimesToCross(List<TravelRequest> travelRequestList) throws InvalidTravelParametersException;
}

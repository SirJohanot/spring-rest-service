package com.patiun.springrestservice.service;

import com.patiun.springrestservice.exception.InvalidTravelParametersException;
import com.patiun.springrestservice.model.TravelRequest;

import java.util.List;

public interface TravelService {

    int calculateTimeToCross(int distance, int speed) throws InvalidTravelParametersException;

    List<Integer> bulkCalculateTimesToCross(List<TravelRequest> travelRequestList) throws InvalidTravelParametersException;
}

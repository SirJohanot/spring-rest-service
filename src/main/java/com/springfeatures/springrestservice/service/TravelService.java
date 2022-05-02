package com.springfeatures.springrestservice.service;

import com.springfeatures.springrestservice.exception.InvalidTravelParametersException;

public interface TravelService {

    int calculateTimeToCross(int distance, int speed) throws InvalidTravelParametersException;
}

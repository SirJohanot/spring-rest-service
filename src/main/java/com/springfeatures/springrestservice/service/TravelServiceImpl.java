package com.springfeatures.springrestservice.service;

import com.springfeatures.springrestservice.caching.InMemoryCache;
import com.springfeatures.springrestservice.exception.InvalidTravelParametersException;
import com.springfeatures.springrestservice.model.TravelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImpl implements TravelService {

    private final InMemoryCache<TravelRequest, Integer> travelCache;

    @Autowired
    public TravelServiceImpl(InMemoryCache<TravelRequest, Integer> travelCache) {
        this.travelCache = travelCache;
    }

    @Override
    public int calculateTimeToCross(int distance, int speed) throws InvalidTravelParametersException {
        if (distance < 0) {
            throw new InvalidTravelParametersException("Distance cannot be less than 0");
        }
        if (speed <= 0) {
            throw new InvalidTravelParametersException("Speed has to be more than 0");
        }
        TravelRequest travelRequest = new TravelRequest(distance, speed);
        Integer result = travelCache.get(travelRequest);
        if (result == null) {
            result = distance / speed;
            travelCache.put(travelRequest, result);
        }
        return result;
    }
}

package com.springfeatures.springrestservice.service;

import com.springfeatures.springrestservice.caching.InMemoryCache;
import com.springfeatures.springrestservice.exception.InvalidTravelParametersException;
import com.springfeatures.springrestservice.model.TimeToCross;
import com.springfeatures.springrestservice.model.TravelParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("travelServiceImpl")
public class TravelServiceImpl implements TravelService {

    private final InMemoryCache<TravelParameters, TimeToCross> travelCache;

    @Autowired
    public TravelServiceImpl(InMemoryCache<TravelParameters, TimeToCross> travelCache) {
        this.travelCache = travelCache;
    }

    @Override
    public TimeToCross calculateTimeToCross(int distance, int speed) throws InvalidTravelParametersException {
        if (distance < 0) {
            throw new InvalidTravelParametersException("Distance cannot be less than 0");
        }
        if (speed <= 0) {
            throw new InvalidTravelParametersException("Speed has to be more than 0");
        }
        TravelParameters travelParameters = new TravelParameters(distance, speed);
        TimeToCross result = travelCache.get(travelParameters);
        if (result == null) {
            result = new TimeToCross(distance / speed);
            travelCache.put(travelParameters, result);
        }
        return result;
    }
}

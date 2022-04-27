package com.springfeatures.springrestservice.service;

import com.springfeatures.springrestservice.exception.InvalidTravelParametersException;
import com.springfeatures.springrestservice.model.TimeToCross;
import org.springframework.stereotype.Service;

@Service("travelServiceImpl")
public class TravelServiceImpl implements TravelService {

    @Override
    public TimeToCross calculateTimeToCross(int distance, int speed) throws InvalidTravelParametersException {
        if (distance < 0) {
            throw new InvalidTravelParametersException("Distance cannot be less than 0");
        }
        if (speed <= 0) {
            throw new InvalidTravelParametersException("Speed has to be more than 0");
        }
        return new TimeToCross(distance / speed);
    }
}

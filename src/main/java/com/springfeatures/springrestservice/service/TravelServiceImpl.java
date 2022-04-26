package com.springfeatures.springrestservice.service;

import com.springfeatures.springrestservice.model.TimeToCross;
import org.springframework.stereotype.Service;

@Service("travelServiceImpl")
public class TravelServiceImpl implements TravelService {

    @Override
    public TimeToCross calculateTimeToCross(int distance, int speed){
        return new TimeToCross(distance/speed);
    }
}

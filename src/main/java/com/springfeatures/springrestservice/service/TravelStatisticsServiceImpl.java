package com.springfeatures.springrestservice.service;

import com.springfeatures.springrestservice.model.BulkTravelResponse;
import com.springfeatures.springrestservice.model.TravelRequest;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TravelStatisticsServiceImpl implements TravelStatisticsService {

    @Override
    public BulkTravelResponse gatherStatisticsAndBuildTravelResponse(List<Integer> calculatedTravelTimes, int responseNumber, List<TravelRequest> travelRequestList) {
        int madeRequestsNumber = travelRequestList.size();
        int invalidRequestsNumber = (int) calculatedTravelTimes.stream()
                .filter(integer -> integer == -1)
                .count();
        int maximumCalculatedTime = calculatedTravelTimes.stream()
                .max(Comparator.comparingInt(i -> i))
                .orElseThrow(NoSuchElementException::new);
        int minimumCalculatedTime = calculatedTravelTimes.stream()
                .min(Comparator.comparingInt(i -> i))
                .orElseThrow(NoSuchElementException::new);
        int mostPopularCalculatedTime = calculatedTravelTimes.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new)
                .getKey();
        return new BulkTravelResponse(calculatedTravelTimes, responseNumber, madeRequestsNumber, invalidRequestsNumber, maximumCalculatedTime, minimumCalculatedTime, mostPopularCalculatedTime);
    }
}

package com.patiun.springrestservice.configuration;

import com.patiun.springrestservice.caching.InMemoryCache;
import com.patiun.springrestservice.model.TravelRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheBeans {

    private static final long TRAVEL_CACHE_ENTRY_LIFE_TIME = 20000000;
    private static final long TRAVEL_CACHE_CLEANUP_INTERVAL = 30000;

    @Bean
    public InMemoryCache<TravelRequest, Integer> travelCache() {
        return new InMemoryCache<>(TRAVEL_CACHE_ENTRY_LIFE_TIME, TRAVEL_CACHE_CLEANUP_INTERVAL);
    }
}

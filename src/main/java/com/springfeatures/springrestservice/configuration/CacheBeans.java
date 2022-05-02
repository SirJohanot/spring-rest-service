package com.springfeatures.springrestservice.configuration;

import com.springfeatures.springrestservice.caching.InMemoryCache;
import com.springfeatures.springrestservice.model.TimeToCross;
import com.springfeatures.springrestservice.model.TravelParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheBeans {

    private static final long TRAVEL_CACHE_ENTRY_LIFE_TIME = 20000000;
    private static final long TRAVEL_CACHE_CLEANUP_INTERVAL = 30000;

    @Bean
    public InMemoryCache<TravelParameters, TimeToCross> travelCache() {
        return new InMemoryCache<>(TRAVEL_CACHE_ENTRY_LIFE_TIME, TRAVEL_CACHE_CLEANUP_INTERVAL);
    }
}
package com.patiun.springrestservice.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class TravelRequestCounterService {

    private final Lock requestsNumberLock = new ReentrantLock();

    private int requestsMadeNumber = 0;

    public void increment() {
        requestsNumberLock.lock();
        try {
            requestsMadeNumber++;
        } finally {
            requestsNumberLock.unlock();
        }
    }

    public int getRequestsMadeNumber() {
        requestsNumberLock.lock();
        try {
            return requestsMadeNumber;
        } finally {
            requestsNumberLock.unlock();
        }
    }
}

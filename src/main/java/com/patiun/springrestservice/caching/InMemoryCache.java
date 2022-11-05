package com.patiun.springrestservice.caching;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InMemoryCache<K, V> {

    private final long entryLifeTime;

    private final Map<K, CacheValue> cacheMap = new HashMap<>();

    private final Lock mapLock = new ReentrantLock();

    public InMemoryCache(long entryLifeTime, final long cleanupInterval) {
        this.entryLifeTime = entryLifeTime;
        Thread cleanupThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(cleanupInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cleanOutdated();
            }
        });
        cleanupThread.setDaemon(true);
        cleanupThread.start();
    }

    private class CacheValue {

        private final long additionTime;

        private final V value;

        public CacheValue(V value) {
            this.additionTime = System.currentTimeMillis();
            this.value = value;
        }
    }

    public int size() {
        mapLock.lock();
        try {
            return cacheMap.size();
        } finally {
            mapLock.unlock();
        }
    }

    public V get(K key) {
        mapLock.lock();
        try {
            CacheValue cacheValue = cacheMap.get(key);
            if (cacheValue == null) {
                return null;
            }
            return cacheValue.value;
        } finally {
            mapLock.unlock();
        }
    }

    public void put(K key, V value) {
        mapLock.lock();
        try {
            cacheMap.put(key, new CacheValue(value));
        } finally {
            mapLock.unlock();
        }
    }

    public void remove(K key) {
        mapLock.lock();
        try {
            cacheMap.remove(key);
        } finally {
            mapLock.unlock();
        }
    }

    public void cleanOutdated() {
        long currentTime = System.currentTimeMillis();
        mapLock.lock();
        try {
            cacheMap.entrySet()
                    .removeIf(
                            kCacheValueEntry -> {
                                CacheValue cacheValue = kCacheValueEntry.getValue();
                                long cacheValueAdditionTime = cacheValue.additionTime;
                                return currentTime - cacheValueAdditionTime > entryLifeTime;
                            });
        } finally {
            mapLock.unlock();
        }
    }
}

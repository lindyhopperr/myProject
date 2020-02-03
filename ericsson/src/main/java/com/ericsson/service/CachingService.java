package com.ericsson.service;

import com.ericsson.exception.RecordNotFoundException;
import com.ericsson.model.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CachingService {

    @Autowired
    private CacheManager cacheManager;

    public void savetoCache(String cacheName, List<Subscribe> subscribes) {
        Cache subscribeCache = getCache(cacheName);

        if (subscribes != null) {
            subscribes.forEach(currSubscribe -> {
                subscribeCache.put(currSubscribe.getId(), currSubscribe);
            });

        }
    }

    public void savetoCache(String cacheName, Subscribe subscribe) {
        Cache subscribeCache = getCache(cacheName);
        subscribeCache.put(subscribe.getId(), subscribe);
    }

    public List<Subscribe> getFromCache(String cacheName) {
        List<Subscribe> subcribes = new ArrayList<>();

        Cache subscribeCache = getCache(cacheName);
        ConcurrentHashMap map = (ConcurrentHashMap) subscribeCache.getNativeCache();
        map.forEach((k, v) -> subcribes.add((Subscribe) v));

        return subcribes;
    }

    public Subscribe getFromCacheById(String cacheName, String id) throws RecordNotFoundException {
        return getCache(cacheName).get(id) != null ? (Subscribe) getCache(cacheName).get(id).get() : null;
    }

    public void evictSingleCacheValue(String cacheName, String id) {
        cacheManager.getCache(cacheName).evict(id);
    }


    public void evictAllCacheValues(String cacheName) {
        cacheManager.getCache(cacheName).clear();
    }

    private Cache getCache(String pCacheName) {
        return cacheManager.getCache(pCacheName);
    }
}

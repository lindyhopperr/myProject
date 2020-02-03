package com.ericsson.service;

import com.ericsson.constant.Constants;
import com.ericsson.model.Subscribe;
import com.ericsson.repository.FileOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Autowired
    private CachingService cachingService;
    @Autowired
    FileOperations fileOperations;

    @Override
    public Subscribe findById(String id) {
        return cachingService.getFromCacheById(Constants.SUBCRIBE_CACHE_NAME, id);
    }

    @Override
    public void add(Subscribe subscribe) {
        cachingService.savetoCache(Constants.SUBCRIBE_CACHE_NAME, subscribe);
    }

    @Override
    public void update(Subscribe subscribe) {
        cachingService.savetoCache(Constants.SUBCRIBE_CACHE_NAME, subscribe);
    }

    @Override
    public void delete(String id) {
        cachingService.evictSingleCacheValue(Constants.SUBCRIBE_CACHE_NAME, id);

    }

    @Override
    public List<Subscribe> getAll() {
        return cachingService.getFromCache(Constants.SUBCRIBE_CACHE_NAME);
    }

    public void refresh() {
        cachingService.evictAllCacheValues(Constants.SUBCRIBE_CACHE_NAME);
    }

    @Override
    public void writeToFile() {
        fileOperations.writeToFile(cachingService.getFromCache(Constants.SUBCRIBE_CACHE_NAME));
        //cachingService.evictAllCacheValues(Constants.SUBCRIBE_CACHE_NAME);
    }

    @Override
    public void readFromFile() {
        cachingService.savetoCache(Constants.SUBCRIBE_CACHE_NAME, fileOperations.readFromFile());
        ;
    }


}

package com.ericsson.config;

import com.ericsson.constant.Constants;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(Constants.SUBCRIBE_CACHE_NAME);
    }
}

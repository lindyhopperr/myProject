package com.stockmarket.stockmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class StockmarketApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(StockmarketApplication.class, args);
    }
}

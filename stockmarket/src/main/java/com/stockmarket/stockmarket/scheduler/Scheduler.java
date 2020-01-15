package com.stockmarket.stockmarket.scheduler;

import com.stockmarket.stockmarket.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Scheduler {
    @Autowired
    private StockService stockService;

    @Scheduled(fixedRate = 3000)
    public void updateStockPrice() {
        stockService.updateStockPrice();
    }
}

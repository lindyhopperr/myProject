package com.stockmarket.stockmarket.service;

import com.stockmarket.stockmarket.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    List<Stock> list();

    void save(Stock stock);

    Optional<Stock> get(Long id);

    void update(Long id, Stock stock);

    void delete(Long id);

    List<Stock>  updateStockPrice();
}

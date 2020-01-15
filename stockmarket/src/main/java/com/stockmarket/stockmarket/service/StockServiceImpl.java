package com.stockmarket.stockmarket.service;

import com.stockmarket.stockmarket.entity.Stock;
import com.stockmarket.stockmarket.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    @Cacheable(value = "stocks")
    public List<Stock> list() {
        return stockRepository.findAll();
    }

    @Override
    public void save(Stock newStock) {
        stockRepository.save(newStock);
    }

    @Override
    public Optional<Stock> get(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public void update(Long id, Stock stock) {
        Stock currentStock = stockRepository.getOne(id);
        currentStock.setCode(stock.getCode());
        currentStock.setName(stock.getName());

        stockRepository.save(currentStock);

    }

    @Override
    public void delete(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    @CachePut(value = "stocks")
    public List<Stock> updateStockPrice() {
        List<Stock> stocks = this.list();

        stocks.forEach(stock -> {
            stock.setPrice(Math.random());
            stock.setLastModifiedDate(new Date());
            //System.out.println(stock.toString());
        });
        return stocks;
    }

}

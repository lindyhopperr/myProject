package com.stockmarket.stockmarket.controller;

import com.stockmarket.stockmarket.entity.Stock;
import com.stockmarket.stockmarket.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/listStocks")
    public List<Stock> listStocks() {
        return stockService.list();
    }

    @PostMapping("/addStock")
    public void addStock(@RequestBody Stock newStock) { stockService.save(newStock); }

    @GetMapping("/getStock/{id}")
    public Optional<Stock> getStock(@PathVariable(value = "id") Long id) {
        return stockService.get(id);
    }

    @PutMapping("/updateStock/{id}")
    public void updateStock(@RequestBody Stock stock, @PathVariable Long id) {
        stockService.update(id, stock);
    }

    @DeleteMapping("/deleteStock/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.delete(id);
    }
}

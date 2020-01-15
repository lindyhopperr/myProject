package com.stockmarket.stockmarket.repository;

import com.stockmarket.stockmarket.entity.UserStocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStocksRepository extends JpaRepository<UserStocks, Long> {
}

package com.stockmarket.stockmarket.service;

import com.stockmarket.stockmarket.entity.User;
import com.stockmarket.stockmarket.entity.UserStocks;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> list();

    void save(User user);

    Optional<User> get(Long id);

    void update(Long id, User user);

    void delete(Long id);

    void sellStock(UserStocks userStocks);

    void buyStock(UserStocks userStocks);

}

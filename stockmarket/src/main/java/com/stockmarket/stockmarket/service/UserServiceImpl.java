package com.stockmarket.stockmarket.service;

import com.stockmarket.stockmarket.entity.Stock;
import com.stockmarket.stockmarket.entity.User;
import com.stockmarket.stockmarket.entity.UserStocks;
import com.stockmarket.stockmarket.repository.UserRepository;
import com.stockmarket.stockmarket.repository.UserStocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserStocksRepository userStocksRepository;

    @Autowired
    StockService stockService;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void update(Long id, User user) {
        User currentUser = userRepository.getOne(id);

        currentUser.setName(user.getName());
        currentUser.setLastName(user.getLastName());
        currentUser.seteMail(user.geteMail());

        userRepository.save(currentUser);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void sellStock(UserStocks userStocks) {
        Optional<UserStocks> currentUserStocks = userStocksRepository.findById(userStocks.getId());
        if (currentUserStocks.get() != null) {
            currentUserStocks.get().setCount(userStocks.getCount() - currentUserStocks.get().getCount());
        }
        userStocksRepository.save(currentUserStocks.get());
    }

    @Override
    public void buyStock(UserStocks userStocks) {
        Optional<Stock> currentStocks = stockService.get(userStocks.getStockId());
        Optional<User> currentUser = userRepository.findById(userStocks.getUserId());

        if (currentStocks.get() != null && currentUser.get() != null) {
            UserStocks currUserStock = checkUserStockInformation(currentStocks.get().getId(), currentUser.get().getId());
            if (currUserStock != null) {
                currUserStock.setCount(currUserStock.getCount() + userStocks.getCount());
            } else {
                currUserStock = userStocks;
            }
            userStocksRepository.save(currUserStock);
        }
    }

    public UserStocks checkUserStockInformation(Long stockId, Long userId) {
        List<UserStocks> currUserStock = userStocksRepository.findAll();
        for (UserStocks userStocks : currUserStock) {
            if (userStocks.getUserId().equals(userId) && userStocks.getStockId().equals(stockId)) {
                return userStocks;
            }
        }
        return null;
    }
}

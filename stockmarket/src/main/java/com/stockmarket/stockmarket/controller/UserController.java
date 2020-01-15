package com.stockmarket.stockmarket.controller;

import com.stockmarket.stockmarket.entity.User;
import com.stockmarket.stockmarket.entity.UserStocks;
import com.stockmarket.stockmarket.repository.UserStocksRepository;
import com.stockmarket.stockmarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserStocksRepository userStocksRepository;

    @GetMapping("/crud/listUsers")
    public List<User> listUsers() {
        return userService.list();
    }

    @PostMapping("/crud/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStock(@RequestBody User newUser) {
        userService.save(newUser);
    }

    @GetMapping("/crud/getUser/{id}")
    public Optional<User> getStock(@PathVariable(value = "id") Long id) {
        return userService.get(id);
    }

    @PutMapping("/crud/updateStock/{id}")
    public void updateStock(@RequestBody User user, @PathVariable Long id) {
        userService.update(id, user);
    }

    @DeleteMapping("/crud/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping("/buyStock")
    public void buyStock(@RequestBody UserStocks userStocks) {
        userService.buyStock(userStocks);
    }

    @PostMapping("/sellStock")
    public void sellStock(@RequestBody UserStocks userStocks) {
        userService.sellStock(userStocks);
    }
}

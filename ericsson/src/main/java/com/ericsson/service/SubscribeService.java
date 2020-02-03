package com.ericsson.service;

import com.ericsson.model.Subscribe;

import java.util.List;

public interface SubscribeService {
    Subscribe findById(String id);

    void add(Subscribe subscribe);

    void update(Subscribe subscribe);

    void delete(String id);

    List<Subscribe> getAll();

    void refresh();

    void writeToFile();

    void readFromFile();
}

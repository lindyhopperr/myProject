package com.ericsson.repository;

import com.ericsson.model.Subscribe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class FileOperations {
    @Value(value = "${data_file_path}")
    private String filePath;

    public void writeToFile(List<Subscribe> subcribes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        createFile(filePath);
        try (FileWriter writer = new FileWriter(filePath, false)) {
            gson.toJson(subcribes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Subscribe> readFromFile() {
        List<Subscribe> outList = new ArrayList<>();
        Gson gson = new Gson();
        Type listOfAnimals = new TypeToken<List<Subscribe>>() {
        }.getType();
        createFile(filePath);
        try (Reader reader = new FileReader(filePath)) {
            outList = gson.fromJson(reader, listOfAnimals);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outList;
    }

    private void createFile(String pFilePath) {
        File file = new File(pFilePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

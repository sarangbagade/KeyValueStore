package com.example.controller;

import com.example.service.IStoreService;
import com.example.service.StoreServiceImpl1;
import javafx.util.Pair;

import java.util.List;

public class StoreController {

    // using IStoreService, business logic present in service is loosely coupled with controller
    private IStoreService abstractStoreServiceImpl1;
    private Object lock = new Object();

    public StoreController()
    {
        this.abstractStoreServiceImpl1 = new StoreServiceImpl1("mapStoreRepo");
    }

    public void add(String key, List<Pair<String, Object>> listOfAttributePairs)
    {
        synchronized (lock) {
            try{
                abstractStoreServiceImpl1.add(key, listOfAttributePairs);
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
        }
    }

    public String keys()
    {
        synchronized (lock) {
            return this.abstractStoreServiceImpl1.keys();
        }
    }

    public String get(String key)
    {
        synchronized (lock) {
            return this.abstractStoreServiceImpl1.get(key);
        }
    }

    public void delete(String key)
    {
        synchronized (lock) {
            try {
                abstractStoreServiceImpl1.delete(key);
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
        }
    }
}

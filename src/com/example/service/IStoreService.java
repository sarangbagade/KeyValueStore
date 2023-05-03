package com.example.service;

import javafx.util.Pair;

import java.util.List;

public interface IStoreService {

    String keys();
    void delete(String key);
    void add(String key, List<Pair<String, Object>> listOfAttributePairs);
    String get(String key);
    List<String> getKeys(String attrKey, String attrValue);
}

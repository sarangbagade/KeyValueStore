package com.example.repository;

import com.example.ValueType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStoreRepo implements IStoreRepository{

    private final Map<String, ValueType> map;

    public InMemoryStoreRepo()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void put(String key, ValueType valueType) {

        this.map.put(key, valueType);
    }

    @Override
    public List<String> keyList() {
        return new ArrayList<>(this.map.keySet());
    }

    @Override
    public ValueType get(String key) {
        return this.map.getOrDefault(key, new ValueType());
    }

    @Override
    public Boolean containsKey(String key) {
        return this.map.containsKey(key);
    }

    @Override
    public void remove(String key) {
        this.map.remove(key);
    }
}

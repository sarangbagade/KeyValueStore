package com.example.repository;

import com.example.ValueType;

import java.util.List;


public interface IStoreRepository {

    // create or update
    public void put(String key, ValueType valueType);

    // read
    public List<String> keyList();
    public ValueType get(String key);
    public Boolean containsKey(String key);

    // delete
    public void remove(String key);
}

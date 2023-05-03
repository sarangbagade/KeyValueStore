package com.example.service;

import com.example.repository.IStoreRepository;
import com.example.repository.InMemoryStoreRepo;

import java.util.List;

public class StoreServiceImpl1 extends AbstractStoreServiceImpl1 {

    public StoreServiceImpl1(String repoType)
    {
        storeRepository = repoFactoryMethod(repoType);
    }

    @Override
    // single responsibility principle. repo objection creation logic present here only
    public IStoreRepository repoFactoryMethod(String repoType) {

        if(repoType.equals("mapStoreRepo")) {
            return new InMemoryStoreRepo();
        } else {
            throw new RuntimeException("invalid repo type provided");
        }
    }
}

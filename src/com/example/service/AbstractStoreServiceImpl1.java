package com.example.service;

import com.example.exception.OperationFailedException;
import com.example.ValueType;
import com.example.repository.IStoreRepository;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public abstract class AbstractStoreServiceImpl1 implements IStoreService{

    // program to an abstraction and not concrete classes. high level component is dependent on abstraction
    IStoreRepository storeRepository;

    // factory method pattern
    public abstract IStoreRepository repoFactoryMethod(String repoType);

    public final String keys()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(String key : storeRepository.keyList())
        {
            stringBuilder.append(key + ",");
        }
        return stringBuilder.toString();
    }

    public final void delete(String key)
    {
        if(key == null || key.isEmpty() || !storeRepository.containsKey(key)) {
            throw new OperationFailedException("mentioned key is invlaid for delete op");
        }
        storeRepository.remove(key);
    }

    public final void add(String key, List<Pair<String, Object>> listOfAttributePairs)
    {
        final ValueType valueType = storeRepository.get(key);

        listOfAttributePairs.forEach(pair -> {
            if(pair.getValue().getClass() != String.class && pair.getValue().getClass() != Integer.class
                    && pair.getValue().getClass() != Double.class && pair.getValue().getClass() != Boolean.class) {
                throw new OperationFailedException("attribute value type is not String/Integer/Double/Boolean");
            }
            if(valueType.containsKey(pair.getKey()) && valueType.get(pair.getKey()).getClass() != pair.getValue().getClass()) {
                throw new OperationFailedException("for attr key:" + pair.getKey()
                        + " data type of the attribute value is mismatching with the existing entry");
            }
            valueType.put(pair.getKey(), pair.getValue());
        });
        storeRepository.put(key, valueType);
    }

    public final String get(String key)
    {
        if(!storeRepository.containsKey(key)) {
            return "null";
        }
        return storeRepository.get(key).toString();
    }

    @Override
    public List<String> getKeys(String attrKey, String attrValue) {
        return null;
    }
}

package com.example;

import java.util.HashMap;
import java.util.Map;

public class ValueType extends HashMap<String, Object>{

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String, Object> entry : entrySet())
        {
            stringBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }
        return stringBuilder.toString();
    }
}

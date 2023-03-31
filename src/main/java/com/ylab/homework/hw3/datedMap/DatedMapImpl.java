package com.ylab.homework.hw3.datedMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DatedMapImpl implements DatedMap {
    private Map<String, String> keyToValueMap = new HashMap<>();
    private Map<String, Date> keyToDateMap = new HashMap<>();

    @Override
    public void put(String key, String value) {
        keyToValueMap.put(key, value);
        keyToDateMap.put(key, new Date());
    }

    @Override
    public String get(String key) {
        return keyToValueMap.get(key);
    }

    @Override
    public boolean containsKey(String key) {
        return keyToValueMap.containsKey(key);
    }

    @Override
    public void remove(String key) {
        keyToValueMap.remove(key);
        keyToDateMap.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return keyToValueMap.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        return keyToDateMap.get(key);
    }
}

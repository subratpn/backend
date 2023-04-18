package com.wellsfargo.backend.cache;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DataCache {

    private Map<Double, Double> dataMap = new ConcurrentHashMap<>();

    public void addBulkData(Map<Double, Double> map) {
        dataMap.putAll(map);
    }

    public void addSingleData(Double x, Double y) {
        dataMap.put(x, y);
    }

    public Map<Double, Double> getDataMap() {
        return dataMap;
    }

    public void clearDataMap() {
        dataMap.clear();
    }

}

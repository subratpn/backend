package com.wellsfargo.backend.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.wellsfargo.backend.cache.DataCache;
import com.wellsfargo.backend.dto.DataObj;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class DataService {

    private final DataCache dataCache;

    public DataService(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public void executeUpload(MultipartFile file) throws IOException, CsvException {
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
        for (String[] strings : csvReader.readAll()) {
            Double x = Double.valueOf(strings[0]);
            Double y = Double.valueOf(strings[1]);
            System.out.println(Arrays.toString(strings));
            dataCache.addSingleData(x, y);
        }
    }

    public List<DataObj> getData() {
        Map<Double, Double> dataMap = dataCache.getDataMap();
        List<DataObj> dataObjList = new LinkedList<>();
        dataMap.forEach((x, y) -> {
            DataObj dataObj = new DataObj(x, y);
            dataObjList.add(dataObj);
        });
        return dataObjList;
    }
}

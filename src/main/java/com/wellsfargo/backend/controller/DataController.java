package com.wellsfargo.backend.controller;

import com.opencsv.exceptions.CsvException;
import com.wellsfargo.backend.dto.DataObj;
import com.wellsfargo.backend.dto.DataRes;
import com.wellsfargo.backend.service.DataService;
import com.wellsfargo.backend.validator.DataValidator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class DataController {

    private final DataValidator dataValidator;

    private final DataService dataService;

    public DataController(DataValidator dataValidator, DataService dataService) {
        this.dataValidator = dataValidator;
        this.dataService = dataService;
    }

    @PostMapping(path = "/data/upload")
    public void uploadDataSet(@RequestParam("file") MultipartFile file) throws IOException, CsvException {
        System.out.println("Upload Engaged");
        dataValidator.isCSV(file);
        dataService.executeUpload(file);
    }

    @GetMapping(path = "/data/fetch")
    public DataRes getDataSet() {
        List<DataObj> dataObjList = dataService.getData();
        return new DataRes(dataObjList);
    }
}

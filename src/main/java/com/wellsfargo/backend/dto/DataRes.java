package com.wellsfargo.backend.dto;

import java.util.List;

public class DataRes {

    private List<DataObj> data;

    public DataRes(List<DataObj> data) {
        this.data = data;
    }

    public List<DataObj> getData() {
        return data;
    }

    public void setData(List<DataObj> data) {
        this.data = data;
    }

}

package com.example.seanlee_takehomeproject.model.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusinessesModel {

    @SerializedName("businesses") private List<BusinessModel> businesses;

    public List<BusinessModel> getBusinesses() {
        return businesses;
    }

}


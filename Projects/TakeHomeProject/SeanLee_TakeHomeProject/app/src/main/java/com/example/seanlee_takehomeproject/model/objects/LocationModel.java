package com.example.seanlee_takehomeproject.model.objects;

import com.google.gson.annotations.SerializedName;

public class LocationModel {

    @SerializedName("address1") private String address;

    public LocationModel(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

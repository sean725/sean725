package com.example.seanlee_takehomeproject.model.objects;

import com.google.gson.annotations.SerializedName;

public class LocationModel {

    @SerializedName("address1") private final String address;
    @SerializedName("state") private final String state;
    @SerializedName("zip_code") private final String zip;

    // TODO: apparently when using retrofit there's no need to have a constructor?
    public LocationModel(String address, String state, String zip) {
        this.address = address;
        this.state = state;
        this.zip = zip;
    }

    public String getAddress() {
        return address + ", " + state + " " + zip;
    }
}

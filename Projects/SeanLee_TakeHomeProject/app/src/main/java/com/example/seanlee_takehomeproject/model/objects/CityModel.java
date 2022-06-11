package com.example.seanlee_takehomeproject.model.objects;

public class CityModel {

    private String id;
    private String name;

    public CityModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}

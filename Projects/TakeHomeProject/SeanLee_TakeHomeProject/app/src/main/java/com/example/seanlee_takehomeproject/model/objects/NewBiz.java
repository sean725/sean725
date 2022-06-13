package com.example.seanlee_takehomeproject.model.objects;

import java.io.Serializable;

public class NewBiz implements Serializable {
    private String id;
    private String title;
    private float rating;
    private String category;
    private String address;
    private String thumbnailUrl;

    public NewBiz(String id, String title, float rating, String category, String address, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.category = category;
        this.address = address;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getId() {return id;}
    public String getTitle() {return title;}
    public float getRating() {return rating;}
    public String getCategory() {return category;}
    public String getAddress() {return address;}
    public String getThumbnailUrl() {return thumbnailUrl;}
}

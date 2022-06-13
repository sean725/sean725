package com.example.seanlee_takehomeproject.model.objects;

import com.google.gson.annotations.SerializedName;

public class CategoryModel {

    @SerializedName("title") private String category;

    public CategoryModel(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}

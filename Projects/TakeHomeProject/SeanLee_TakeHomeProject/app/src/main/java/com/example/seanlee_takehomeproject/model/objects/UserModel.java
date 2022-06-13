package com.example.seanlee_takehomeproject.model.objects;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("name") private final String author;

    public UserModel(String author) {
        this.author = author;
    }

    public String getAuthor() { return this.author; }
}

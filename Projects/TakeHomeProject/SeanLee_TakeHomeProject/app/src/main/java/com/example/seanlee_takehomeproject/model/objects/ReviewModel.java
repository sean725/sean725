package com.example.seanlee_takehomeproject.model.objects;

import com.google.gson.annotations.SerializedName;

public class ReviewModel {

    @SerializedName("user") private final UserModel user;
    @SerializedName("time_created") private final String date;
    @SerializedName("rating") private final float rating;
    @SerializedName("text") private final String content;

    public ReviewModel(UserModel user, String date, float rating, String content) {
        this.user = user;
        this.date = date;
        this.rating = rating;
        this.content = content;
    }

    public String getAuthor() {return this.user.getAuthor();}
    public String getDate() {return date;}
    public float getRating() {return rating;}
    public String getContent() {return content;}
}

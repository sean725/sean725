package com.example.seanlee_takehomeproject.model.objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ReviewsModel {

    @SerializedName("reviews") private List<ReviewModel> reviews;

    public ReviewsModel(List<ReviewModel> reviews) {
        this.reviews = reviews;
    }

    public List<ReviewModel> getReviews() {
        List<ReviewModel> retVal = new ArrayList<>();
        for(int x=0; x<3; x++){
            retVal.add(this.reviews.get(x));
        }
        return retVal;
    }
}

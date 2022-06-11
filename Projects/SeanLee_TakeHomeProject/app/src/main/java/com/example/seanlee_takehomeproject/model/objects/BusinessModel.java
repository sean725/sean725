package com.example.seanlee_takehomeproject.model.objects;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BusinessModel{

    @SerializedName("id") private String id;
    @SerializedName("name") private String title;
    @SerializedName("rating") private float rating;
    @SerializedName("categories") private List<CategoryModel> category;
    @SerializedName("location") private LocationModel address;
    @SerializedName("image_url") private String thumbnailUrl;

    public BusinessModel(String id, String title, float rating, List<CategoryModel> category, LocationModel address, String thumbnailUrl) {
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
    public List<CategoryModel> getCategory() {return category;}
    public String getCategoryString(){
        String cate = "";
        for (int x=0; x<this.category.size(); x++){
            cate += this.category.get(x).getCategory();
            if(x < this.category.size() - 1){ cate += " / "; }
        }
        return cate;
    }
    public LocationModel getLocationModel() {return address;}
    public String getLocationString() {
        return this.getLocationModel().getAddress();
    }
    public String getThumbnailUrl(){return thumbnailUrl;}

    public void setId(String id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setRating(float rating) {this.rating = rating;}
    public void setCategory(List<CategoryModel> category) {this.category = category;}
    public void setLocationModel(LocationModel address) {this.address = address;}
    public void setThumbnailUrl(String thumbnailUrl) {this.thumbnailUrl = thumbnailUrl;}

}

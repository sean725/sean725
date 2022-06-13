package com.example.seanlee_takehomeproject.model.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusinessModel{

    @SerializedName("id") private String id;
    @SerializedName("name") private String title;
    @SerializedName("rating") private float rating;
    @SerializedName("categories") private List<CategoryModel> category;
    @SerializedName("location") private LocationModel address;
    @SerializedName("image_url") private String thumbnailUrl;

    public String getId() {return id;}
    public String getTitle() {return title;}
    public float getRating() {return rating;}

    public String getCategoryString(){
        StringBuilder cate = new StringBuilder();
        for (int x=0; x<this.category.size(); x++){
            cate.append(this.category.get(x).getCategory());
            if(x < this.category.size() - 1){ cate.append(" / "); }
        }
        return cate.toString();
    }
    public LocationModel getLocationModel() {return address;}
    public String getLocationString() {
        return this.getLocationModel().getAddress();
    }
    public String getThumbnailUrl(){return thumbnailUrl;}

}

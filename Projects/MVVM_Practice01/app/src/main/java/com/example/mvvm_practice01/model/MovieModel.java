package com.example.mvvm_practice01.model;

public class MovieModel {

    private String title;
    private String image;

    // c-tor
    public MovieModel(String _title, String _image) {
        this.title = _title;
        this.image = _image;
    }

    // getter
    public String getTitle() { return title; }
    public String getImage() { return image; }

    // setter
    public void setTitle(String title) { this.title = title; }
    public void setImage(String image) { this.image = image; }
}

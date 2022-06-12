package com.example.seanlee_takehomeproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.seanlee_takehomeproject.R;
import com.example.seanlee_takehomeproject.adapter.CityAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CityAdapter mAdapter;

    // TODO: Questions
    // 1. is it a good practice to perform all screens via fragments? or should I have multiple activities?
    // since Fragment brings you to previous fragment state...
    // all should performed via activities

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> cities = new ArrayList<>();
        cities.add("San Francisco"); cities.add("New York"); cities.add("Seattle"); cities.add("San Jose"); cities.add("Chicago");

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        RecyclerView rv = findViewById(R.id.city_recyclerView);
        rv.setLayoutManager(layoutManager);
        mAdapter = new CityAdapter(this, cities);
        rv.setAdapter(mAdapter);
    }
}
package com.example.seanlee_takehomeproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seanlee_takehomeproject.R;
import com.example.seanlee_takehomeproject.adapter.BizAdapter;
import com.example.seanlee_takehomeproject.model.objects.BusinessModel;
import com.example.seanlee_takehomeproject.model.objects.BusinessesModel;
import com.example.seanlee_takehomeproject.util.DividerDecoration;
import com.example.seanlee_takehomeproject.viewmodel.BusinessesViewModel;

import java.util.List;

public class BizActivity extends AppCompatActivity {

    private List<BusinessModel> mCollection;
    private BizAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biz);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String cityName = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        TextView tv_title = findViewById(R.id.biz_title);
        tv_title.setText(" Here are places to explore in " + cityName + "!");
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        RecyclerView rv = findViewById(R.id.biz_recyclerView);
        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(new DividerDecoration(this));
        mAdapter = new BizAdapter(this, mCollection);
        rv.setAdapter(mAdapter);

        BusinessesViewModel businessesVM = new ViewModelProvider(this).get(BusinessesViewModel.class);
        businessesVM.getBusinessesObserver().observe(this, businessesModel -> {
            if(businessesModel != null){
                mCollection = businessesModel.getBusinesses();
                mAdapter.setCollection(businessesModel.getBusinesses());
            }
        });
        businessesVM.callApi(cityName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.seanlee_takehomeproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seanlee_takehomeproject.view.BizActivity;
import com.example.seanlee_takehomeproject.R;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.VH> {

    public static final String TAG = "CityAdapter.TAG";
    private final Context mContext;
    private final List<String> mCollection;

    public CityAdapter(Context _context, List<String> _collection) {
        this.mContext = _context;
        this.mCollection = _collection;
    }

    @NonNull
    @Override
    public CityAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_city, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.VH holder, int position) {
        holder.tv_name.setText(mCollection.get(position));
        int pos = position;
        holder.position = pos;
    }

    @Override
    public int getItemCount() {
        if(mCollection != null){ return mCollection.size(); }
        return 0;
    }

    public class VH extends RecyclerView.ViewHolder{

        final TextView tv_name;
        int position;

        public VH(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.row_city_name);

            itemView.setOnClickListener(view -> {
                // start biz activity with id
                // maybe use interface? or just open activity here?
                Intent intent = new Intent(itemView.getContext(), BizActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, mCollection.get(position));
                Log.i(TAG, "onCityClick: " + mCollection.get(position));
                itemView.getContext().startActivity(intent);
            });
        }
    }
}

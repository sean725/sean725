package com.example.mvvm_practice01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm_practice01.R;
import com.example.mvvm_practice01.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private Context mContext;
    private List<MovieModel> mCollection;

    public MovieListAdapter(Context _context, List<MovieModel> _collection){
        this.mContext = _context;
        this.mCollection = _collection;
    }

    public void setCollection(List<MovieModel> _collection){
        this.mCollection = _collection;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {
        holder.mTitle.setText(mCollection.get(position).getTitle());
        Glide.with(mContext)
                .load(mCollection.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        if(mCollection != null){
            return mCollection.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle;
        ImageView mImage;

        public MyViewHolder(View itemView){
            super(itemView);
            mTitle = itemView.findViewById(R.id.row_title);
            mImage = itemView.findViewById(R.id.row_image);
        }
    }
}

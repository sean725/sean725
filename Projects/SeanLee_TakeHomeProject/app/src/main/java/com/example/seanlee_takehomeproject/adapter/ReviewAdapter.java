package com.example.seanlee_takehomeproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seanlee_takehomeproject.R;
import com.example.seanlee_takehomeproject.model.objects.ReviewModel;

import org.w3c.dom.Text;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.VH> {

    Context mContext;
    private List<ReviewModel> mCollection;

    public ReviewAdapter(Context _context, List<ReviewModel> _reviews) {
        this.mContext = _context;
        this.mCollection = _reviews;
    }

    public void setCollection(List<ReviewModel> _reviews){
        this.mCollection = _reviews;
        notifyDataSetChanged();;
    }

    @NonNull
    @Override
    public ReviewAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_review, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.VH holder, int position) {
        holder.tv_author.setText(mCollection.get(position).getAuthor());
        holder.tv_rating.setText(String.valueOf(mCollection.get(position).getRating()));
        holder.tv_date.setText(mCollection.get(position).getDate());
        holder.ratingBar.setRating(mCollection.get(position).getRating());
        holder.tv_content.setText(mCollection.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        if(mCollection!=null){return mCollection.size();}
        return 0;
    }

    public class VH extends RecyclerView.ViewHolder{
        TextView tv_author;
        TextView tv_date;
        TextView tv_rating;
        RatingBar ratingBar;
        TextView tv_content;

        public VH(View itemView) {
            super(itemView);
            tv_author = itemView.findViewById(R.id.row_review_name);
            tv_date = itemView.findViewById(R.id.row_review_date);
            tv_rating = itemView.findViewById(R.id.row_review_ratingInt);
            ratingBar = itemView.findViewById(R.id.row_review_ratingBar);
            tv_content = itemView.findViewById(R.id.row_review_content);
        }
    }
}

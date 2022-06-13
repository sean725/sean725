package com.example.seanlee_takehomeproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seanlee_takehomeproject.model.objects.BusinessModel;
import com.example.seanlee_takehomeproject.model.objects.NewBiz;
import com.example.seanlee_takehomeproject.view.BizDetailActivity;
import com.example.seanlee_takehomeproject.R;
import com.example.seanlee_takehomeproject.util.DBManager;

import java.util.List;

public class BizAdapter extends RecyclerView.Adapter<BizAdapter.VH> {

    Context mContext;
    private String mCity;
    private List<BusinessModel> mCollection;

    public BizAdapter(Context _context, List<BusinessModel> _businesses, String _city) {
        this.mContext = _context;
        this.mCollection = _businesses;
        this.mCity = _city;
    }

    public void setCollection(List<BusinessModel> _businesses){
        this.mCollection = _businesses;
        notifyDataSetChanged();;
    }

    @NonNull
    @Override
    public BizAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_biz, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BizAdapter.VH holder, int position) {
        holder.tv_name.setText(mCollection.get(position).getTitle());
        holder.mBusiness = mCollection.get(position);

        // check if the business is liked already
        DBManager db = DBManager.getInstance(mContext);
        if(db.isLiked(mCollection.get(position).getTitle())){ // liked
            holder.btn_like.setBackgroundResource(R.drawable.ic_baseline_thumb_up_alt_24); // change resource
        }else {
            holder.btn_like.setBackgroundResource(R.drawable.ic_baseline_thumb_up_off_alt_24); // change resource
        }
    }

    @Override
    public int getItemCount() {
        if(mCollection != null){ return mCollection.size(); }
        return 0;
    }

    public class VH extends RecyclerView.ViewHolder{

        TextView tv_name;
        ImageButton btn_like;
        BusinessModel mBusiness;

        public VH(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.row_biz_name);
            btn_like = itemView.findViewById(R.id.row_biz_btn_like);

            // view click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // start detail activity
                    Intent intent = new Intent(itemView.getContext(), BizDetailActivity.class);

                    NewBiz extra = new NewBiz(mBusiness.getId(), mBusiness.getTitle(), mBusiness.getRating(), mBusiness.getCategoryString(), mBusiness.getLocationString(), mBusiness.getThumbnailUrl());
                    intent.putExtra("EXTRA_BIZ", extra);
                    itemView.getContext().startActivity(intent);
                }
            });

            // like button click
            btn_like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // check if it's liked already
                    DBManager db = DBManager.getInstance(mContext);
                    int result = db.handleLikeBtn(mBusiness.getId());
                    if(result == DBManager.LIKE_ON){ // change to like
                        btn_like.setBackgroundResource(R.drawable.ic_baseline_thumb_up_alt_24); // change resource
                    }else{
                        btn_like.setBackgroundResource(R.drawable.ic_baseline_thumb_up_off_alt_24); // change resource
                    }
                }
            });
        }
    }
}

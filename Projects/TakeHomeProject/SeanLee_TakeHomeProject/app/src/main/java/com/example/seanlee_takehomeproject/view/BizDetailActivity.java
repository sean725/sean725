package com.example.seanlee_takehomeproject.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seanlee_takehomeproject.R;
import com.example.seanlee_takehomeproject.adapter.ReviewAdapter;
import com.example.seanlee_takehomeproject.model.objects.NewBiz;
import com.example.seanlee_takehomeproject.model.objects.ReviewModel;
import com.example.seanlee_takehomeproject.util.DBManager;
import com.example.seanlee_takehomeproject.util.DividerDecoration;
import com.example.seanlee_takehomeproject.util.StringUtil;
import com.example.seanlee_takehomeproject.viewmodel.ReviewsViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BizDetailActivity extends AppCompatActivity {

    // This screen will contain...
    // thumbnail, name, rating, address, and category
    // like feature -> allow user to like a business and persist likes across searches. use DB to store business likes.
    // display 3 reviews
    // provide back button

    private List<ReviewModel> mCollection;
    private ReviewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biz_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        NewBiz business = (NewBiz) getIntent().getSerializableExtra("EXTRA_BIZ");

        setTitle(business.getTitle());

        // TODO: should I move UI portion to a separate function?
        TextView tv_name = findViewById(R.id.biz_detail_title);
        ImageButton ib_like = findViewById(R.id.biz_detail_btn_like);
        ImageView iv_thumbnail = findViewById(R.id.biz_detail_thumbnail);
        TextView tv_ratingInt = findViewById(R.id.biz_detail_ratingInt);
        RatingBar ratingBar = findViewById(R.id.biz_detail_ratingBar);
        TextView tv_category = findViewById(R.id.biz_detail_category);
        TextView tv_address = findViewById(R.id.biz_detail_address);
        RecyclerView rv_reviews = findViewById(R.id.biz_detail_reviews);

        DBManager db = DBManager.getInstance(this);
        // TODO: is it a bad practice to pass views to DBManager class and handle button background change?

        // handle like button
        ib_like.setOnClickListener(view -> {
            int result = db.handleLikeBtn(business.getId());
            if(result == DBManager.LIKE_ON){
                ib_like.setBackgroundResource(R.drawable.ic_baseline_thumb_up_alt_24); // change resource
                StringUtil.displayToast(getApplicationContext(), business.getTitle(), StringUtil.MSG_LIKE);
            }else{
                ib_like.setBackgroundResource(R.drawable.ic_baseline_thumb_up_off_alt_24); // change resource
                StringUtil.displayToast(getApplicationContext(), business.getTitle(), StringUtil.MSG_UNLIKE);
            }
        });
        boolean isLiked = db.isLiked(business.getId());

        // change button background
        if(isLiked){
            ib_like.setBackgroundResource(R.drawable.ic_baseline_thumb_up_alt_24); // change resource
        }else{
            ib_like.setBackgroundResource(R.drawable.ic_baseline_thumb_up_off_alt_24); // change resource
        }

        tv_name.setText(business.getTitle());
        tv_ratingInt.setText(String.valueOf(business.getRating()));
        tv_category.setText(business.getCategory());
        tv_address.setText(business.getAddress());
        ratingBar.setRating(business.getRating());
        Picasso.get().load(business.getThumbnailUrl()).into(iv_thumbnail);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        rv_reviews.setLayoutManager(layoutManager);
        rv_reviews.addItemDecoration(new DividerDecoration(this));
        mAdapter = new ReviewAdapter(this, mCollection); // get reviews from api then populate
        rv_reviews.setAdapter(mAdapter);

        ReviewsViewModel viewModel = new ViewModelProvider(this).get(ReviewsViewModel.class);
        viewModel.getReviewsObserver().observe(this, reviewsModel -> {
            if(reviewsModel != null){
                mCollection = reviewsModel.getReviews();
                mAdapter.setCollection(reviewsModel.getReviews());
            }
        });
        viewModel.callApi(business.getId());
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

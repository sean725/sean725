package com.example.seanlee_takehomeproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.seanlee_takehomeproject.model.api.APIService;
import com.example.seanlee_takehomeproject.model.api.RetroInstance;
import com.example.seanlee_takehomeproject.model.objects.ReviewsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewsViewModel extends ViewModel {

    private final MutableLiveData<ReviewsModel> mCollection;
    public ReviewsViewModel() { mCollection = new MutableLiveData<>(); }
    public MutableLiveData<ReviewsModel> getReviewsObserver(){ return mCollection; }

    public void callApi(String _id){

        APIService service = RetroInstance.getRetroClient().create(APIService.class);
        Call<ReviewsModel> call = service.getReviews(RetroInstance.apiKeyBuilder(), _id);
        call.enqueue(new Callback<ReviewsModel>() {
            @Override
            public void onResponse(Call<ReviewsModel> call, Response<ReviewsModel> response) {
                mCollection.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ReviewsModel> call, Throwable t) {
                mCollection.postValue(null);
            }
        });
    }
}

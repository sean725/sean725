package com.example.seanlee_takehomeproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.seanlee_takehomeproject.model.objects.BusinessesModel;
import com.example.seanlee_takehomeproject.model.api.APIService;
import com.example.seanlee_takehomeproject.model.api.RetroInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessesViewModel extends ViewModel {

    private final MutableLiveData<BusinessesModel> mCollection;
    public BusinessesViewModel() { mCollection = new MutableLiveData<>(); }
    public MutableLiveData<BusinessesModel> getBusinessesObserver(){ return mCollection; }

    public void callApi(String _id){

        APIService service = RetroInstance.getRetroClient().create(APIService.class);
        Call<BusinessesModel> call = service.getBusinesses(RetroInstance.apiKeyBuilder(), _id, 10);
        call.enqueue(new Callback<BusinessesModel>() {
            @Override
            public void onResponse(Call<BusinessesModel> call, Response<BusinessesModel> response) {
                mCollection.postValue(response.body());
            }

            @Override
            public void onFailure(Call<BusinessesModel> call, Throwable t) {
                mCollection.postValue(null);
            }
        });
    }
}

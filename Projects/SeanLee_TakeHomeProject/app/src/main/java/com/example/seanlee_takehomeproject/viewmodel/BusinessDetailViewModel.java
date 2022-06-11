package com.example.seanlee_takehomeproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.seanlee_takehomeproject.model.objects.BusinessModel;
import com.example.seanlee_takehomeproject.model.api.APIService;
import com.example.seanlee_takehomeproject.model.api.RetroInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessDetailViewModel extends ViewModel {

    private MutableLiveData<BusinessModel> mBusiness;

    public BusinessDetailViewModel() { mBusiness = new MutableLiveData<>(); }
    public MutableLiveData<BusinessModel> getBusinessObserver(){ return mBusiness; }

    public void callApi(String _businessId){

//        APIService service = RetroInstance.getRetroClient().create(APIService.class);
//        Call<BusinessModel> call = service.getBusinessDetail(RetroInstance.apiKeyBuilder(), _businessId); // where to get input?
//        call.enqueue(new Callback<BusinessModel>() {
//            @Override
//            public void onResponse(Call<BusinessModel> call, Response<BusinessModel> response) {
//                mBusiness.postValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<BusinessModel> call, Throwable t) {
//                mBusiness.postValue(null);
//            }
//        });
    }

}

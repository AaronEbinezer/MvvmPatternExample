package com.example.mvvmpatterneg.repository;

import android.content.Context;

import com.example.mvvmpatterneg.api.ApiService;
import com.example.mvvmpatterneg.model.GetAllInfo;
import com.example.mvvmpatterneg.model.GetAllInfoDetail;

import java.util.List;

import io.reactivex.Single;

public class GetAllInfoRepo extends BaseRepository {
    ApiService apiService;
    public GetAllInfoRepo(ApiService apiService, Context context) {
        super(apiService, context);
        this.apiService=apiService;
    }

    public Single<GetAllInfoDetail> getPlantDetails(){
        return apiService.getProductDetail().flatMap(res->{
            return Single.just(res);
        });
    }


}

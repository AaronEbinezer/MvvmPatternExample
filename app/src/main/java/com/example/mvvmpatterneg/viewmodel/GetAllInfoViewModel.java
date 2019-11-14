package com.example.mvvmpatterneg.viewmodel;

import com.example.mvvmpatterneg.model.GetAllInfoDetail;
import com.example.mvvmpatterneg.repository.GetAllInfoRepo;
import com.example.mvvmpatterneg.vo.Resource;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GetAllInfoViewModel extends ViewModel {

    GetAllInfoRepo allInfoRepo;

    public GetAllInfoViewModel(GetAllInfoRepo allInfoRepo) {
        this.allInfoRepo = allInfoRepo;
    }

    MutableLiveData<Resource<GetAllInfoDetail>>details=new MutableLiveData<>();

    public GetAllInfoRepo getAllInfoRepo() {
        return allInfoRepo;
    }

    public void setAllInfoRepo(GetAllInfoRepo allInfoRepo) {
        this.allInfoRepo = allInfoRepo;
    }

    public MutableLiveData<Resource<GetAllInfoDetail>> getDetails() {
        return details;
    }

    public void setDetails(MutableLiveData<Resource<GetAllInfoDetail>> details) {
        this.details = details;
    }

    public Disposable getProductDetails() {
        return allInfoRepo.getPlantDetails().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resource -> {
                    details.setValue(Resource.success(resource));
                }, throwable -> details.setValue(Resource.error(throwable.getMessage(), null)));
    }
}

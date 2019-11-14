package com.example.mvvmpatterneg.ui.viewmodel.factorymodel;

import com.example.mvvmpatterneg.repository.GetAllInfoRepo;
import com.example.mvvmpatterneg.ui.viewmodel.GetAllInfoViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class GetAllInfoFactoryModel implements ViewModelProvider.Factory {

    GetAllInfoRepo allInfoRepo;

    public GetAllInfoFactoryModel(GetAllInfoRepo allInfoRepo) {
        this.allInfoRepo = allInfoRepo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GetAllInfoViewModel(allInfoRepo);
    }
}

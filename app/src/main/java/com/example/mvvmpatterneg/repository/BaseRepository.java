package com.example.mvvmpatterneg.repository;

import android.content.Context;

import com.example.mvvmpatterneg.api.ApiService;


public class BaseRepository {
    ApiService sessionService;
    Context context;

    public BaseRepository(ApiService sessionService, Context context){
        this.sessionService = sessionService;
        this.context = context;
    }
}

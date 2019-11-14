package com.example.mvvmpatterneg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmpatterneg.api.RetroClient;
import com.example.mvvmpatterneg.model.GetAllInfo;
import com.example.mvvmpatterneg.model.GetAllInfoDetail;
import com.example.mvvmpatterneg.repository.GetAllInfoRepo;
import com.example.mvvmpatterneg.viewmodel.GetAllInfoViewModel;
import com.example.mvvmpatterneg.viewmodel.factorymodel.GetAllInfoFactoryModel;
import com.example.mvvmpatterneg.vo.Status;

public class MainActivity extends AppCompatActivity {

    GetAllInfoFactoryModel factoryModel;
    GetAllInfoViewModel getAllInfoViewModel;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        factoryModel=new GetAllInfoFactoryModel(new GetAllInfoRepo(RetroClient.getApiService(),MainActivity.this));

        getAllInfoViewModel= ViewModelProviders.of(this,factoryModel).get(GetAllInfoViewModel.class);
        getAllInfoViewModel.getDetails().observe(this, res->{
            if (res == null) {
                return;
            }

            String message = res.message;
            GetAllInfoDetail allInfo=res.data;
            if (res.status.equals(Status.LOADING)) {
                //TODO show progress bar
//                progressBar.setVisibility(View.VISIBLE);//hide progress
            } else {
                //hideProgressBar();
                if (message != null && res.status.equals(Status.ERROR)) {
                    Log.e(TAG, "Exception:" + message);
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                } else if (allInfo != null) {
                    Log.d(TAG, "onCreate: "+allInfo.getData().get(0).getBrand());
                }
            }
        });

        getAllInfoViewModel.getProductDetails();
    }
}

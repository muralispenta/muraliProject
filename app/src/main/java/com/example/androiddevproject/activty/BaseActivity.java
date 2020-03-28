package com.example.androiddevproject.activty;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddevproject.interf.AppAwareness;

public class BaseActivity extends AppCompatActivity implements AppAwareness {

    @Override
    public boolean checkInternetConnection() {
        return false;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



}

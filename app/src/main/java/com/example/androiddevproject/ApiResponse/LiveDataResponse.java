package com.example.androiddevproject.ApiResponse;

import com.example.androiddevproject.IApiResponse;
import com.example.androiddevproject.model.LiveData;
import com.example.androiddevproject.utils.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LiveDataResponse implements IApiResponse {
    @Override
    public boolean isSuccess() {
        return false;
    }

    @SerializedName(Constants.DATA)
    public ArrayList<LiveData> liveData;

}

package com.example.androiddevproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androiddevproject.ApiCallAdapter;
import com.example.androiddevproject.ApiCallsInterFace;
import com.example.androiddevproject.ApiResponse.LiveDataResponse;
import com.example.androiddevproject.ApiResponse.LoginResponse;
import com.example.androiddevproject.R;
import com.example.androiddevproject.activty.HomeActivity;
import com.example.androiddevproject.activty.login.LoginActivity;
import com.example.androiddevproject.utils.Constants;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_userdetails, container, false);

    }
    private void startLogin(String name, String password) {


        ApiCallsInterFace cancerApiService = ApiCallAdapter.getClient
                (getActivity()).create(ApiCallsInterFace.class);

        JSONObject jsonLogin = new JSONObject();
        try {
            jsonLogin.put(Constants.NAME, name);
            jsonLogin.put(Constants.PASSWORD, password);

        } catch (Exception e) {
            // Crashlytics.logException(e);
        }

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse(Constants.MEDIA_PARSE),
                jsonLogin.toString());

        Call<LiveDataResponse> call = cancerApiService.liveResponse(body);

        call.enqueue(new Callback<LiveDataResponse>() {
            @Override
            public void onResponse(@NonNull Call<LiveDataResponse> call,
                                   @NonNull Response<LiveDataResponse> response) {
                if (response.body() != null && response.body().isSuccess()) {
                   // startActivity(new Intent(getActivity(), HomeActivity.class));
                }else{
                    Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onFailure(@NonNull Call<LiveDataResponse> call, @NonNull Throwable t) {

            }
        });
    }


}

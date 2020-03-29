package com.example.androiddevproject.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevproject.ApiCallAdapter;
import com.example.androiddevproject.ApiCallsInterFace;
import com.example.androiddevproject.ApiResponse.LiveDataResponse;
import com.example.androiddevproject.ApiResponse.LoginResponse;
import com.example.androiddevproject.R;
import com.example.androiddevproject.activty.HomeActivity;
import com.example.androiddevproject.activty.login.LoginActivity;
import com.example.androiddevproject.adapter.LiveDataAdapter;
import com.example.androiddevproject.model.LiveData;
import com.example.androiddevproject.sqlite.AppDatabaseClient;
import com.example.androiddevproject.sqlite.UserDao;
import com.example.androiddevproject.sqlite.UserEntity;
import com.example.androiddevproject.utils.Constants;

import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataFragment extends Fragment {
    private RecyclerView recyclerView;
    private LiveDataAdapter liveDataAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_userdetails, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        View view = getView();
        if (view == null) return;
        recyclerView = view.findViewById(R.id.recylerview);
        super.onActivityCreated(savedInstanceState);
        startLogin();

}

    private void setAdapter(ArrayList<LiveData> liveData) {
        if (liveData == null || liveData.isEmpty()) {
            return;
        }

        liveDataAdapter = new LiveDataAdapter(liveData , getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(liveDataAdapter);
        recyclerView.setVisibility(View.VISIBLE);
    }



    private void startLogin() {

        ApiCallsInterFace cancerApiService = ApiCallAdapter.getClient
                (getActivity()).create(ApiCallsInterFace.class);


        Call<LiveDataResponse> call = cancerApiService.liveResponse();


        call.enqueue(new Callback<LiveDataResponse>() {
            @Override
            public void onResponse(@NonNull Call<LiveDataResponse> call,
                                   @NonNull Response<LiveDataResponse> response) {
                if (response.body() != null && response.body().liveData != null) {
                    setAdapter(response.body().liveData);
                    saveUserToDatabase(response.body().liveData);
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

    private void saveUserToDatabase(final ArrayList<LiveData> users) {

        @SuppressLint("StaticFieldLeak")
        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //adding to database
                UserDao userDao = AppDatabaseClient.getInstance(getActivity()).getAppDatabase()
                        .userDao();

                userDao.deletAll();

                for (LiveData user : users) {

                    UserEntity userEntity = new UserEntity();
                    userEntity.setEmail(user.getName());
                    userEntity.setFirstName(user.getFirst_name());

                    userDao.insert(userEntity);
                }



                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }

        SaveTask st = new SaveTask();
        st.execute();

    }



}

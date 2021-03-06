package com.example.androiddevproject.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androiddevproject.ApiCallAdapter;
import com.example.androiddevproject.ApiCallsInterFace;
import com.example.androiddevproject.ApiResponse.LoginResponse;
import com.example.androiddevproject.R;
import com.example.androiddevproject.UserDetails;
import com.example.androiddevproject.model.LiveData;
import com.example.androiddevproject.utils.Constants;

import org.json.JSONObject;

import javax.sql.DataSource;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileFragment extends Fragment {

    private ImageView imgProfile;
    private TextView txtUsername,txtFullName,txtLastName;
    private LiveData liveData;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_avtar, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        View view = getView();
        if (view == null) return;
        imgProfile = view.findViewById(R.id.imgProfile);
        txtUsername = view.findViewById(R.id.txtUserName);
        txtFullName = view.findViewById(R.id.txtFullName);
        txtLastName = view.findViewById(R.id.txtLastName);
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle == null) return;
        liveData = bundle.getParcelable(Constants.DATA);
       renderProfile();
    }


    private void renderProfile() {

        txtUsername.setText(liveData.getName());
        txtFullName.setText(liveData.getFirst_name());
        txtLastName.setText(liveData.getLast_name());



        //imgProfile.
    }

}


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
import com.example.androiddevproject.utils.Constants;

import org.json.JSONObject;

import javax.sql.DataSource;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileFragment extends Fragment {

    private ImageView imgProfile;
    private TextView txtUsername;

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
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        assert bundle != null;
        UserDetails data = bundle.getParcelable(Constants.DATA);

    }


    private void renderProfile(UserDetails userDetails) {



        txtUsername.setText(userDetails.getName());
        //imgProfile.
    }

}


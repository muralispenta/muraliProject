package com.example.androiddevproject.activty.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddevproject.ApiCallAdapter;
import com.example.androiddevproject.ApiCallsInterFace;
import com.example.androiddevproject.ApiResponse.LoginResponse;
import com.example.androiddevproject.R;
import com.example.androiddevproject.activty.HomeActivity;
import com.example.androiddevproject.utils.Constants;
import com.example.androiddevproject.utils.Utils;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity  extends AppCompatActivity {

    private TextInputLayout txtInputLayoutUserName, txtInputLayoutPassword;
    private EditText editUserName,editPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registerView();
    }
    private void  registerView(){
        txtInputLayoutUserName = findViewById(R.id.textInputLayoutUserName);
        txtInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        editUserName = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
    }

    public void attemptLogin() {
        Utils.resetFormInputField(txtInputLayoutUserName);
        Utils.resetFormInputField(txtInputLayoutPassword);

        Utils.hideKeyboard(this, txtInputLayoutUserName);

        // Store values at the time of the login attempt.
        String email = editUserName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password
        if (TextUtils.isEmpty(password)) {
            Utils.reportFormInputFieldError(txtInputLayoutPassword, getString(R.string.empty_password_error));
            focusView = editPassword;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            Utils.reportFormInputFieldError(txtInputLayoutUserName, getString(R.string.email_username_error));
            focusView = editUserName;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }

            startLogin(email, password);
        }


    private void startLogin(String name, String password) {


        ApiCallsInterFace cancerApiService = ApiCallAdapter.getClient
                (LoginActivity.this).create(ApiCallsInterFace.class);

        JSONObject jsonLogin = new JSONObject();
        try {
            jsonLogin.put(Constants.NAME, name);
            jsonLogin.put(Constants.PASSWORD, password);

        } catch (Exception e) {
           // Crashlytics.logException(e);
        }

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse(Constants.MEDIA_PARSE),
                jsonLogin.toString());

        Call<LoginResponse> call = cancerApiService.login(body);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call,
                                   @NonNull Response<LoginResponse> response) {
                if (response.body() != null && response.body().isSuccess()) {
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    if (response.body().userDetails == null) return;
                 } else{
                    Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();


                                    }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {

            }
        });
    }

}



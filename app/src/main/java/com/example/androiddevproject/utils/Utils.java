package com.example.androiddevproject.utils;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputLayout;

public class Utils {


    public static void resetFormInputField(TextInputLayout textInputLayout) {
        if (textInputLayout == null) return;
        textInputLayout.setErrorEnabled(false);
        textInputLayout.setError("");
    }


    public static void hideKeyboard(Context context, View view) {
        if (context == null || view == null) return;
        IBinder token = view.getWindowToken();
        if (token == null) return;
        InputMethodManager imm = (InputMethodManager) context.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(token, 0);
    }

    public static void reportFormInputFieldError(TextInputLayout textInputLayout, String errMsg) {
        if (textInputLayout == null) return;
        textInputLayout.setErrorEnabled(true);
        textInputLayout.setError(errMsg);
    }


}

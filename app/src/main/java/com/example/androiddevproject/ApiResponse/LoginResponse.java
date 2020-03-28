package com.example.androiddevproject.ApiResponse;

import com.example.androiddevproject.IApiResponse;
import com.example.androiddevproject.UserDetails;
import com.example.androiddevproject.utils.Constants;
import com.google.gson.annotations.SerializedName;

public class LoginResponse  implements IApiResponse {

    @SerializedName(Constants.STATUS)
    public String status;
    @SerializedName(Constants.MESSAGE)
    public String message;

//
//    @SerializedName(Constants.DATA)
//    public UserDetails userDetails;
//
//    @SerializedName(Constants.PAGE)
//    private int page;
//
//    @SerializedName(Constants.PER_PAGE)
//    private int per_page;
//
//    @SerializedName(Constants.TOTAL_PAGES)
//    private int total_pages;

@SerializedName(Constants.TOKEN)
private String token;
    @Override
    public boolean isSuccess() {
        return !token.isEmpty();
    }
}

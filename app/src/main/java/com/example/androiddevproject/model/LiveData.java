package com.example.androiddevproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.androiddevproject.utils.Constants;
import com.google.gson.annotations.SerializedName;

public class LiveData implements Parcelable {

    @SerializedName(Constants.ADDRESS)
    private String address;
    @SerializedName(Constants.NAME)
    private String name;
    @SerializedName(Constants.AVATAR)
    private String avatar;
    @SerializedName(Constants.FIRST_NAME)
    private String first_name;
    @SerializedName(Constants.LAST_NAME)
    private String last_name;
    /*@SerializedName(Constants.EMAIL)
    private String email;*/


    public LiveData(String address, String name, String avatar, String first_name, String last_name/*,String email*/) {
        this.address = address;
        this.name = name;
        this.avatar = avatar;
        this.first_name = first_name;
        this.last_name = last_name;
      //  this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    /*public String getEmail() {
        return email;
    }*/

    protected LiveData(Parcel in) {
    }

    public static final Creator<LiveData> CREATOR = new Creator<LiveData>() {
        @Override
        public LiveData createFromParcel(Parcel in) {
            return new LiveData(in);
        }

        @Override
        public LiveData[] newArray(int size) {
            return new LiveData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(avatar);
        dest.writeString(first_name);
        dest.writeString(last_name);
      //  dest.writeString(email);
    }
}

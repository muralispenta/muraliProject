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

    public LiveData(String address, String name,String avatar) {
        this.address = address;
        this.name = name;
        this.avatar = avatar;
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
    }
}

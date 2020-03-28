package com.example.androiddevproject;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.SyncStateContract;

import com.example.androiddevproject.utils.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ConcurrentModificationException;

public class UserDetails implements Parcelable {

    protected UserDetails(Parcel in) {
        id = in.readInt();
        name = in.readString();
        year = in.readString();
    }

    public static final Creator<UserDetails> CREATOR = new Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel in) {
            return new UserDetails(in);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @SerializedName(Constants.ID)
    private int id;
    @SerializedName(Constants.NAME)
    private String name;
    @SerializedName(Constants.YEAR)
    private String year;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public UserDetails(int id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(year);
    }


}

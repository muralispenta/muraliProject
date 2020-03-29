package com.example.androiddevproject.sqlite;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseClient {

    private Context mCtx;
    private static AppDatabaseClient mInstance;

    private AppDatabase appDatabase;

    private AppDatabaseClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "CSquare").build();
    }

    public static synchronized AppDatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new AppDatabaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}

package com.example.androiddevproject.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.androiddevproject.utils.data.NetworkStatusCodes;

public class DataUtil {

    public static boolean isInternetAvailable(Context context) {
        return getConnectionStatus(context) == NetworkStatusCodes.NET_CONNECTED;
    }

    public static int getConnectionStatus(Context context) {
        if (context == null) return NetworkStatusCodes.NET_DISCONNECTED;
        final ConnectivityManager conMgr = (ConnectivityManager) context.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr == null) return NetworkStatusCodes.NET_DISCONNECTED;
        NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            if (networkInfo.isConnected()) {
                return NetworkStatusCodes.NET_CONNECTED;
            } else if (networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                return NetworkStatusCodes.NET_CONNECTING;
            }
        }
        return NetworkStatusCodes.NET_DISCONNECTED;
    }


}

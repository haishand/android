package com.dtos.drivingstudy.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dtos.drivingstudy.base.BaseApplication;

/**
 * Created by haishand on 7/20/2016.
 */
public class DeviceUtils {

    public static boolean hasInternet() {
        ConnectivityManager cm = (ConnectivityManager) BaseApplication.context().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();

    }
}

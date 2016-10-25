package com.dtos.drivingstudy.app;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dtos.drivingstudy.R;
import com.dtos.drivingstudy.base.BaseApplication;
import com.dtos.drivingstudy.config.AppConfig;

/**
 * Created by haishand on 7/20/2016.
 */
public class AppContext extends BaseApplication {
    private static AppContext _instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        initApp();
    }

    private void initApp() {
        // init app config file
        AppConfig.instance(_context).init();
    }

    public static AppContext instance() {
        return _instance;
    }

    // package info
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }

}

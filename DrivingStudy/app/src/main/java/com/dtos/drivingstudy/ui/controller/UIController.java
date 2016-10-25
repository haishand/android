package com.dtos.drivingstudy.ui.controller;

import android.app.Activity;
import android.content.Intent;

import com.dtos.drivingstudy.ui.MainActivity;
import com.dtos.drivingstudy.ui.DetailActivity;

/**
 * Created by haishand on 7/24/2016.
 */
public class UIController {

    public static void showMain(Activity context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void showMyFee(Activity context) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(DetailActivity.BUNDLE_KEY_DISPLAY_TYPE, DetailActivity.DISPLAY_MY_FEE);
        context.startActivity(intent);
    }

}

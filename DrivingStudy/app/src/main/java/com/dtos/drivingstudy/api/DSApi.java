package com.dtos.drivingstudy.api;

import android.util.Log;

import com.dtos.drivingstudy.config.BuildConfig;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by haishand on 7/21/2016.
 * NOTE: RequestParams key should be compliance with DTMS移动端接口定义
 */
public class DSApi {

//    public final static String API_HOST_URL = "http://27.223.110.150:81/dtms/mobile/%s";     // TEST ONLY
    public final static String API_HOST_URL = "http://dtms.ronganjx.com/dtms/mobile/%s";

    // actions
    public static final String DS_LOGIN_ACTION = "doLogin.action";
    public static final String DS_FETCH_RESERV_CALENDAR_ACTION = "findCanOrderDate.action";

    // login
    public static void login(String username,
                             String password,
                             AsyncHttpResponseHandler respHandler) {

        RequestParams params = new RequestParams();
        params.add("userCode", username);
        params.add("userPass", password);
        HttpClientApi.post(getAbsoluteApiUrl(DS_LOGIN_ACTION), params, respHandler);
    }

    public static void fetchReservCalendar(String stuCode, int year, int month, AsyncHttpResponseHandler respHandler) {
        RequestParams params = new RequestParams();
        params.add("stuCode", stuCode);
        params.add("year", Integer.toString(year));
        params.add("month", Integer.toString(month));
        HttpClientApi.post(getAbsoluteApiUrl(DS_FETCH_RESERV_CALENDAR_ACTION), params, respHandler);
    }

    private static String getAbsoluteApiUrl(String action) {
        String url = String.format(API_HOST_URL, action);
        if( BuildConfig.DEBUG)
            Log.d(HttpClientApi.class.getName(), url);
        return url;
    }
}

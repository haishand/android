package com.dtos.drivingstudy.api;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by haishand on 7/22/2016.
 */
public class HttpClientApi {

    private static AsyncHttpClient _client = new AsyncHttpClient();

    static {
        // httpclient default configuration
//        _client.setTimeout(10*1000);
//        _client.setURLEncodingEnabled(true);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler handler) {
        _client.post(url, params, handler);
    }

    public static AsyncHttpClient getClient() {
        return _client;
    }

}

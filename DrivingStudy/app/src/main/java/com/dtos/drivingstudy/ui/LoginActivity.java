package com.dtos.drivingstudy.ui;

import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.dtos.drivingstudy.R;
import com.dtos.drivingstudy.api.DSApi;
import com.dtos.drivingstudy.app.AppContext;
import com.dtos.drivingstudy.ui.base.BaseActivity;
import com.dtos.drivingstudy.bean.ResultInfo;
import com.dtos.drivingstudy.bean.LoginInfo;
import com.dtos.drivingstudy.bean.UserInfo;
import com.dtos.drivingstudy.config.AppConfig;
import com.dtos.drivingstudy.config.BuildConfig;
import com.dtos.drivingstudy.ui.controller.UIController;
import com.dtos.drivingstudy.util.DeviceUtils;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import butterknife.Bind;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    // for logging
    private static final String LOGTAG = LoginActivity.class.getName();

    String username, password;
    @Bind(R.id.et_username)
    AppCompatEditText etUsername;
    @Bind(R.id.et_password)
    AppCompatEditText etPassword;

    @Override
    @OnClick(R.id.btn_login)
    public void onClick(View v) {
        if(BuildConfig.DEBUG) {
            Log.d(LoginActivity.class.getName(), "OnClick()");
        }
        handleLogin();
    }

    private void handleLogin() {
        if (!readyForLogin()) {
            return;
        }

        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setIsLogin(true);
        loginInfo.setUserCode(username);
        loginInfo.setUserPass(password);
        AppConfig.instance(_context).setBean(loginInfo);

        showWaitDialog(R.string.logining);
        DSApi.login(username, password, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                if (BuildConfig.DEBUG)
                    Log.d(LOGTAG, response.toString());

                ResultInfo result = JSON.parseObject(response.toString(), ResultInfo.class);
                if(result.getData() != null) {
                    UserInfo userInfo = JSON.parseObject(result.getData(), UserInfo.class);
                    Log.d(LOGTAG, userInfo.getUserName());
                    AppConfig.instance(_context).setBean(userInfo);
                    onLoginComplete();
                }else {
                    // error
                    AppContext.showToast(result.getErrorInfo());
                }
//                onLoginComplete();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                AppContext.showToast("网络出错：" + statusCode);
                Log.d(LOGTAG, "Error: " + throwable.getMessage());

                // TODO: remember to remove it after testing
                onLoginComplete();
            }

            // should overwritten this one to catch abnormal error, such as 403 forbidden
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                AppContext.showToast("网络出错：" + statusCode);
                Log.d(LOGTAG, "Error: " + throwable.getMessage());

                // TODO: remember to remove it after testing
                onLoginComplete();
            }

            @Override
            public void onFinish() {
                super.onFinish();

                hideWaitDialog();
            }
        });
    }

    private void onLoginComplete() {
//        AppContext.instance().isLogin = true;
        UIController.showMain(_context);
        finish();
    }

    private boolean readyForLogin() {
        if (!DeviceUtils.hasInternet()) {
            AppContext.showToast(R.string.tip_no_internet);
            return false;
        }

        // check
        if (etUsername.length() == 0) {
            etUsername.setError("请输入用户名");
            etUsername.requestFocus();
            return false;
        }
        if (etPassword.length() == 0) {
            etPassword.setError("请输入密码");
            etPassword.requestFocus();
            return false;
        }

        return true;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        // load login info
        LoginInfo logInfo = AppConfig.instance(_context).getBean(LoginInfo.class);
        if(logInfo != null) {
            etUsername.setText(logInfo.getUserCode());
            etPassword.setText(logInfo.getUserPass());
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}

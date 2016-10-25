package com.dtos.drivingstudy.bean;

/**
 * Created by haishand on 7/24/2016.
 */
public class LoginInfo implements Bean {
    private String userCode;
    private String userPass;

    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        isLogin = isLogin;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String getBeanName() {
        return LoginInfo.class.getName();
    }
}

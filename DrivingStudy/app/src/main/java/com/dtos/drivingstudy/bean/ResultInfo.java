package com.dtos.drivingstudy.bean;

/**
 * Created by haishand on 7/24/2016.
 */
public class ResultInfo implements Bean {
    private String data;
    private String errorInfo;
    private int status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getBeanName() {
        return ResultInfo.class.getName();
    }
}

package com.dtos.drivingstudy.ui.dialog;

import android.app.ProgressDialog;

/**
 * Created by haishand on 7/22/2016.
 */
public interface IProgDialog {
    public abstract void hideWaitDialog();

    public abstract ProgressDialog showWaitDialog();

    public abstract ProgressDialog showWaitDialog(int resid);

    public abstract ProgressDialog showWaitDialog(String text);
}

package com.dtos.drivingstudy.ui.base;

import android.support.v7.app.ActionBar;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.dtos.drivingstudy.R;
import com.dtos.drivingstudy.base.AppManager;
import com.dtos.drivingstudy.ui.dialog.CommonToast;
import com.dtos.drivingstudy.ui.dialog.IProgDialog;
import com.dtos.drivingstudy.util.DialogHelper;
import com.dtos.drivingstudy.util.StringUtils;

import butterknife.ButterKnife;

/**
 * Created by haishand on 7/20/2016.
 */
public abstract class BaseActivity extends AppCompatActivity
        implements IProgDialog, IBaseView {   // AppCompatActivity for compatibility concerning

    protected BaseActivity _context;
    private ProgressDialog _waitDialog = null;
    protected ActionBar mActionBar;
    protected LayoutInflater mInflater;
    private boolean _isVisible;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _context = this;
        AppManager.getInstance().addActivity(this);
        onBeforeSetContentLayout();
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        mActionBar = getSupportActionBar();
        mInflater = getLayoutInflater();
        if(hasActionBar()) {
            initActionBar(mActionBar);
        }

        ButterKnife.bind(this);

        init(savedInstanceState);
        initView();
        initData();
        _isVisible = true;
    }

    protected void init(Bundle savedInstanceState) {
    }

    protected void initActionBar(ActionBar actionBar) {
        if(actionBar == null) {
            return;
        }
        if(hasBackButton()) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }else {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
            actionBar.setDisplayUseLogoEnabled(false);
            int titleRes = getActionBarTitle();
            if (titleRes != 0) {
                actionBar.setTitle(titleRes);
            }
        }
    }

    protected int getActionBarTitle() {
        return R.string.app_name;
    }

    protected boolean hasBackButton() {
        return false;
    }

    protected boolean hasActionBar() {
        return getSupportActionBar() != null;
    }

    protected int getLayoutId() {
        return 0;
    }

    protected void onBeforeSetContentLayout() {
    }

    protected void setActionBarTitle(int resId) {
        if (resId != 0) {
            setActionBarTitle(getString(resId));
        }
    }

    protected void setActionBarTitle(String title) {
        if (StringUtils.isEmpty(title)) {
            title = getString(R.string.app_name);
        }
        if (hasActionBar() && mActionBar != null) {
            mActionBar.setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        AppManager.getInstance().finishActivity(this);
    }

    // toast related
    public void showToast(int msgResid, int icon, int gravity) {
        showToast(getString(msgResid), icon, gravity);
    }

    public void showToast(String message, int icon, int gravity) {
        CommonToast toast = new CommonToast(this);
        toast.setMessage(message);
        toast.setMessageIc(icon);
        toast.setLayoutGravity(gravity);
        toast.show();
    }

    // ProgressDialog related
    @Override
    public void hideWaitDialog() {
        if (_isVisible && _waitDialog != null) {
            try {
                _waitDialog.dismiss();
                _waitDialog = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public ProgressDialog showWaitDialog() {
        return showWaitDialog(R.string.loading);
    }

    @Override
    public ProgressDialog showWaitDialog(int resid) {
        return showWaitDialog(getString(resid));
    }

    @Override
    public ProgressDialog showWaitDialog(String text) {
        if(_isVisible) {
            if (_waitDialog == null) {
                _waitDialog = DialogHelper.getWaitDialog(this, text);
            }
            if(_waitDialog != null) {
                _waitDialog.setMessage(text);
                _waitDialog.show();
            }
            return _waitDialog;
        }
        return null;
    }

}

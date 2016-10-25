package com.dtos.drivingstudy.ui;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.dtos.drivingstudy.R;
import com.dtos.drivingstudy.ui.base.BaseActivity;
import com.dtos.drivingstudy.ui.base.BaseFragment;
import com.dtos.drivingstudy.ui.fragment.MyFeeDetailFragment;

public class DetailActivity extends BaseActivity {

    public static final String BUNDLE_KEY_DISPLAY_TYPE = "BUNDLE_KEY_DISPLAY_TYPE";
    public static final int DISPLAY_MY_FEE = 10;
    public static final int DISPLAY_MY_RESERVATION = 20;
    public static final int DISPLAY_MY_COACH = 30;
    public static final int DISPLAY_SIGNUP = 40;
    public static final int DISPLAY_SETTING = 50;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

        int type = getIntent().getIntExtra(BUNDLE_KEY_DISPLAY_TYPE, DISPLAY_MY_FEE);
        BaseFragment fragment = null;
        int actionBarTitle = 0;
        switch(type) {
            case DISPLAY_MY_FEE:
                actionBarTitle = R.string.actionbar_title_my_fee;
                fragment = new MyFeeDetailFragment();
                break;
            default:
                break;
        }
        setActionBarTitle(actionBarTitle);
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.container, fragment);
        trans.commitAllowingStateLoss();

    }



    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }
}

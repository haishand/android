package com.dtos.drivingstudy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dtos.drivingstudy.R;
import com.dtos.drivingstudy.ui.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by haishand on 9/1/2016.
 */
public class MyFeeDetailFragment extends BaseFragment {
/*    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_fee, container, false);

        ButterKnife.bind(this, view);

        return view;
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initView(view);
        initData();
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_fee;
    }
}

package com.dtos.drivingstudy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dtos.drivingstudy.R;
import com.dtos.drivingstudy.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by haishand on 7/25/2016.
 */
public class ShuttleFragment extends NavFragment {
    @Bind(R.id.text)
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shuttle, container, false);

        ButterKnife.bind(this, view);
//        text.setText(getTitle());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

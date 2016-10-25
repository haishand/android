package com.dtos.drivingstudy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dtos.drivingstudy.R;
import com.dtos.drivingstudy.api.DSApi;
import com.dtos.drivingstudy.ui.base.BaseFragment;
import com.dtos.drivingstudy.ui.widget.calendar.CalendarView;
import com.loopj.android.http.JsonHttpResponseHandler;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by haishand on 7/25/2016.
 */
public class ReservFragment extends NavFragment {

    @Bind(R.id.calendar_view)
    CalendarView calendarView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reserv, container, false);

        ButterKnife.bind(this, view);

        calendarView.updateCalendar();
        return view;
    }

    private void updateOrderDateInfo() {
        String organCode;
        String stuCode;
        int year;
        int month;
 /*       DSApi.fetchReservCalendar(organCode, stuCode, year, month, new JsonHttpResponseHandler() {

        };*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}

package com.dtos.drivingstudy.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dtos.drivingstudy.R;
import com.dtos.drivingstudy.ui.base.BaseActivity;
import com.dtos.drivingstudy.ui.base.BaseFragment;
import com.dtos.drivingstudy.bean.UserInfo;
import com.dtos.drivingstudy.config.AppConfig;
import com.dtos.drivingstudy.ui.controller.UIController;
import com.dtos.drivingstudy.ui.fragment.ExamFragment;
import com.dtos.drivingstudy.ui.fragment.NavFragment;
import com.dtos.drivingstudy.ui.fragment.ReservFragment;
import com.dtos.drivingstudy.ui.fragment.ShuttleFragment;
import com.dtos.drivingstudy.util.BeanUtils;
import com.githang.viewpagerindicator.IconPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // logging
    private static final String LOGTAG = MainActivity.class.getName();

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.indicator)
    com.githang.viewpagerindicator.IconTabPageIndicator indicator;
    @Bind(R.id.divider)
    View divider;
    @Bind(R.id.view_pager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);

        //
        initViews();
    }


    private void initViews() {
        List<NavFragment> fragments = initFragments();

        FragmentAdapter adapter = new FragmentAdapter(fragments, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        // load nav view user info
        View headerView =  navView.getHeaderView(0);
        TextView userName = (TextView) headerView.findViewById(R.id.username);
        TextView subject = (TextView) headerView.findViewById(R.id.subject);
        UserInfo user = AppConfig.instance(this).getBean(UserInfo.class);
        if(user != null) {
            userName.setText(user.getUserName());
            subject.setText(BeanUtils.getSubjectName(user.getSubjectType()));
        }

    }

    private List<NavFragment> initFragments() {
        List<NavFragment> list = new ArrayList<NavFragment>();

        NavFragment exam = new ExamFragment();
        exam.setTitle(getString(R.string.bottom_nav_exam));
        exam.setIconId(R.drawable.bottom_navbar_exam_selector);
        list.add(exam);

        NavFragment reserv = new ReservFragment();
        reserv.setTitle(getString(R.string.bottom_nav_reservation));
        reserv.setIconId(R.drawable.bottom_navbar_reserv_selector);
        list.add(reserv);

        NavFragment shuttle = new ShuttleFragment();
        shuttle.setTitle(getString(R.string.bottom_nav_shuttle));
        shuttle.setIconId(R.drawable.bottom_navbar_shuttle_selector);
        list.add(shuttle);

        return list;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Handle the action
        if (id == R.id.nav_my_fee) {
            UIController.showMyFee(this);
        } else if (id == R.id.nav_my_reservation) {

        } else if (id == R.id.nav_my_coach) {

        } else if (id == R.id.nav_pre_signup) {

        } else if (id == R.id.nav_setting) {
//            UIController.showSetting(this._context);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class FragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
        private List<NavFragment> mFragments;

        public FragmentAdapter(List<NavFragment> fragments, FragmentManager fm) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        @Override
        public int getIconResId(int index) {
            return mFragments.get(index).getIconId();
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragments.get(position).getTitle();
        }
    }

}

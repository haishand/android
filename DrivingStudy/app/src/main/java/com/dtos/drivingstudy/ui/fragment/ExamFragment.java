package com.dtos.drivingstudy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dtos.drivingstudy.R;
import com.dtos.drivingstudy.app.AppContext;
import com.dtos.drivingstudy.ui.base.BaseFragment;
import com.dtos.drivingstudy.ui.widget.CircleMenu;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by haishand on 7/25/2016.
 */
public class ExamFragment extends NavFragment {
    @Bind(R.id.circle_menu)
    CircleMenu circleMenu;
    @Bind(R.id.text)
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exam, container, false);

        ButterKnife.bind(this, view);

//        text.setText(getTitle());
        InitCircleMenu();
        return view;
    }

    private void InitCircleMenu() {
        final String[] itemTexts = new String[]{
                "错题练习",
                "专项练习",
                "章节练习",
                "随机练习",
                "顺序练习",
                "我的成绩",
        };
        final int[] itemIcons = new int[]{
                R.drawable.ic_error_practice,
                R.drawable.ic_special_practice,
                R.drawable.ic_chapter_practice,
                R.drawable.ic_random_practice,
                R.drawable.ic_seq_practice,
                R.drawable.ic_my_score,
        };

        circleMenu.setRotating(true);//是否启用旋转
        circleMenu.setItems(itemTexts, itemIcons);//显示文字及图标
        //circleMenu.setItems(itemIcons);//只显示图标
        circleMenu.setIconSize(60);//图标大小，单位为dp
        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenu.ItemView view) {
                AppContext.showToast(itemTexts[view.getPosition()]);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

package com.dtos.drivingstudy.base;

import com.dtos.drivingstudy.ui.base.BaseActivity;

import java.util.Stack;

/**
 * Created by haishand on 7/20/2016.
 */

public class AppManager {

    private static Stack<BaseActivity> actStack = null; //activity stack
    private static AppManager instance = null;  // singleton, it's thread-safe because all activities are running in one thread

    private AppManager() {
        actStack = new Stack<BaseActivity>();
    }

    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    public void addActivity(BaseActivity act) {
        actStack.add(act);
    }

    public void finishActivity(BaseActivity act) {
        if(act != null) {
            actStack.remove(act);
            act.finish();
            act = null;
        }
    }
}

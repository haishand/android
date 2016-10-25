package com.dtos.drivingstudy.config;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.dtos.drivingstudy.bean.Bean;
import com.dtos.drivingstudy.bean.UserInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by haishand on 7/23/2016.
 */
public class AppConfig {

    public static final String APP_NAME = "DSApp";
    public static final Object LOG_FILE = "DSApp.log";
    private final static String APP_CONFIG = "DSApp.cfg";
    public static final String CONF_APP_UNIQUEID = "APP_UNIQUEID";

    private static AppConfig _instance;
    private final Context _context;
    private Properties _props = null;

    private AppConfig(Context context) {
        this._context = context;

        init();
    }

    public static AppConfig instance(Context context) {
        if (_instance == null) {
            _instance = new AppConfig(context);
        }
        return _instance;
    }

    public void init() {
        _props = new Properties();
        createCfgFile();
    }

    public void createCfgFile() {
        File dir = _context.getDir(APP_CONFIG, Context.MODE_PRIVATE);
        File cfg = new File(dir, APP_CONFIG);
        try {
            cfg.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void storeProps() {
        FileOutputStream fos = null;

        try {
            File dir = _context.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            File conf = new File(dir, APP_CONFIG);
            fos = new FileOutputStream(conf);
            _props.store(fos, null);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadProps() {
        FileInputStream fis = null;

        File conf = _context.getDir(APP_CONFIG, Context.MODE_PRIVATE);
        try {
            fis = new FileInputStream(conf.getPath() + File.separator + APP_CONFIG);
            _props.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public String get(String key) {
        loadProps();
        return _props.getProperty(key);
    }

    public void set(String key, String value) {
        _props.setProperty(key, value);
        storeProps();
    }

    public void setBean(Bean bean) {
        Log.d("MYDEBUG", JSON.toJSONString(bean));
        set(bean.getBeanName(), JSON.toJSONString(bean));
    }

    public <T extends Bean> T getBean(Class<T> cls) {
        String val = get(cls.getName());
        if (val == null) return null;
        return (T) JSON.parseObject(val, cls);
    }

    public void saveUserInfo(UserInfo user) {
        loadProps();
        _props.setProperty("rowId", String.valueOf(user.getRowId()));
        _props.setProperty("userName", user.getUserName());
        _props.setProperty("userGender", String.valueOf(user.getUserGender()));
        _props.setProperty("menuCodeList", JSON.toJSONString(user.getMenuCodeList()));

    }

    public UserInfo loadUserInfo() {
        UserInfo user = new UserInfo();
        loadProps();
        user.setRowId(Long.valueOf(_props.getProperty("rowId")));
        user.setUserName(_props.getProperty("userName"));
        user.setUserGender(Integer.valueOf(_props.getProperty("userGender")));

        return user;
    }
}

package com.dtos.drivingstudy.util;

/**
 * Created by haishand on 8/16/2016.
 */
public class BeanUtils {
    public static String getSubjectName(int type) {
        String name = null;

        switch(type) {
            case 1:
                name = "报名";
                break;
            case 2:
                name = "开班";
                break;
            case 10:
                name = "科目一";
                break;
            case 20:
                name = "科目二";
                break;
            case 30:
                name = "科目三";
                break;
            case 40:
                name = "科目四";
                break;
            default:
                name = null;
        }
        return name;
    }
}

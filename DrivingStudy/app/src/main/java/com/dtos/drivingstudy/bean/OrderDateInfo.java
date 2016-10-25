package com.dtos.drivingstudy.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by haishand on 8/16/2016.
 */
public class OrderDateInfo implements Bean {
    private List<Date> orderDateList;           // 可预约课程日期
    private List<Date> examDateList;            // 可预约考试日期
    private List<Date> orderedClassDateList;     // 已预约课程日期

    public List<Date> getOrderDateList() {
        return orderDateList;
    }

    public void setOrderDateList(List<Date> orderDateList) {
        this.orderDateList = orderDateList;
    }

    public List<Date> getExamDateList() {
        return examDateList;
    }

    public void setExamDateList(List<Date> examDateList) {
        this.examDateList = examDateList;
    }

    public List<Date> getOrderedClassDateList() {
        return orderedClassDateList;
    }

    public void setOrderedClassDateList(List<Date> orderedClassDateList) {
        this.orderedClassDateList = orderedClassDateList;
    }

    @Override
    public String getBeanName() {
        return OrderDateInfo.class.getName();
    }
}

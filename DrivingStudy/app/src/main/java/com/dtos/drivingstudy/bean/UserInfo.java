package com.dtos.drivingstudy.bean;

import java.util.List;

/**
 * Created by haishand on 7/23/2016.
 */
public class UserInfo implements Bean {
    private long rowId;                     // 用户表主键
    private String userName;                // 用户姓名
    private String ownCode;                 // 用户CODE （学员为stuCode，教练为coachCode）
    private int userGender;                 // 性别#1:女;2:男;
    private List<String> menuCodeList;      // 移动端菜单CODE集合（以此来判断移动端的菜单权限）
    private int stuStatus;                  // 学员状态#1:正常; 2:退学; 3:毕业; 4:退班;
    private int subjectType;                // 科目状态#1:报名;2:开班;10:科目一 ;20:科目二;30:科目三;40:科目四; (当学员状态为正常时，已此值为准)
    private String address;                 // 用户联系地址
    private String vehicleKind;                // 学员驾照类型

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOwnCode() {
        return ownCode;
    }

    public void setOwnCode(String ownCode) {
        this.ownCode = ownCode;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public List<String> getMenuCodeList() {
        return menuCodeList;
    }

    public void setMenuCodeList(List<String> menuCodeList) {
        this.menuCodeList = menuCodeList;
    }

    public int getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(int stuStatus) {
        this.stuStatus = stuStatus;
    }

    public int getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(int subjectType) {
        this.subjectType = subjectType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVehicleKind() {
        return vehicleKind;
    }

    public void setVehicleKind(String vehicleKind) {
        this.vehicleKind = vehicleKind;
    }

    @Override
    public String getBeanName() {
        return UserInfo.class.getName();
    }
}

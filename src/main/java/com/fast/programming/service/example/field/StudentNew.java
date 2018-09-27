package com.fast.programming.service.example.field;

/**
 * 外部系统学生信息
 *
 * @author bowen.yan
 * @date 2018-08-08
 */
public class StudentNew {
    private String userName;
    private String mobile;
    private String address;

    public StudentNew(String userName, String mobile, String address) {
        this.userName = userName;
        this.mobile = mobile;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

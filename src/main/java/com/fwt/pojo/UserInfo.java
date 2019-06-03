package com.fwt.pojo;

import org.hibernate.validator.constraints.Length;

public class UserInfo {
    int    userId;
    @Length(min =20,max = 30,message = "名字不合法，长度为6~20")
    String userName;
    @Length(min = 20,max = 30,message = "密码不合法，密码长度为6~20")
    String password;
    String regEmail;
    String mobile;
    String icon;

    public UserInfo() {
    }

    public UserInfo(int userId, String userName, String password, String regEmail, String mobile, String icon) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.regEmail = regEmail;
        this.mobile = mobile;
        this.icon = icon;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", regEmail='" + regEmail + '\'' +
                ", mobile='" + mobile + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

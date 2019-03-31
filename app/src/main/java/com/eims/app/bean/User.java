package com.eims.app.bean;

/**
 * @author bobo
 * @date 2018/9/1
 * describe
 */
public class User {

    /**
     * expirationTime : 1567267200000
     * openingTime : 1534337327000
     * mobile : 15575163734
     * userName : 王静波
     * type : 1
     * userId : 58
     */

    private long expirationTime;
    private long openingTime;
    private long mobile;
    private String userName;
    private int type;
    private int userId;

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public long getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(long openingTime) {
        this.openingTime = openingTime;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

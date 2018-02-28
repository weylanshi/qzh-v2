package com.huidong.qzh.util.common.constant;

public enum LoginStatus {

    LOGOUT_STATUS(400),LOGIN_STATUS(200),LOGIN_ERROR(403),SYS_ERROR(500);

    private int status;

    LoginStatus(int status) {
        this.status = status;
    }


    public int getStatus() {
        return status;
    }

}

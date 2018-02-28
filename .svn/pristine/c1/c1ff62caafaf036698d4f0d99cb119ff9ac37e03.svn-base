package com.huidong.qzh.util.common.util;

/**
 * 数据返回结构
 */
public class QzhResult<T> {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private T data;


    public static <T> QzhResult build(Integer status, String msg, T data) {
        return new QzhResult(status, msg, data);
    }

    public static QzhResult build(Integer status, String msg) {
        return new QzhResult(status, msg, "");
    }

    public static <T> QzhResult build(Integer status, T data) {
        return new QzhResult(status, "", data);
    }

    public static QzhResult ok() {
        return new QzhResult("");
    }

    public static <T> QzhResult ok(T object) {
        return new QzhResult(object);
    }

    public static <T> QzhResult ok(String msg, T data) {
        return QzhResult.build(200, msg, data);
    }

    public static QzhResult error() {
        return QzhResult.build(500, "ERROR", "");
    }

    public static <T> QzhResult error(T object) {
        return QzhResult.build(500, "ERROR", object);
    }

    public static <T> QzhResult error(String msg, T data) {
        return QzhResult.build(500, msg, data);
    }

    public QzhResult() {
    }

    public QzhResult(T data) {
        this.data = data;
        this.msg = "OK";
        this.status = 200;
    }

    public QzhResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "QzhResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

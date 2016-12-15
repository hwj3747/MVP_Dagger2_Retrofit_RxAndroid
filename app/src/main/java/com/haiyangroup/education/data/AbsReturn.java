package com.haiyangroup.education.data;

/**
 * Created by Administrator on 2015/12/29.
 */
public class AbsReturn<V> {
    String message;
    V data;
    int  code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

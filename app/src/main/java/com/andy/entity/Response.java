package com.andy.entity;

import java.util.Objects;

/**
 * 请求的应答实体类
 * <p>
 * Created by andy on 17-2-14.
 */

public class Response {

    /**
     * 判断请求是否成功的依据
     */
    private boolean isSuccess;

    /**
     * 关于请求的信息
     */
    private String msg;

    /**
     * 结果,可以为 null
     */
    private Objects obj;

    public Response(boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Objects getObj() {
        return obj;
    }

    public void setObj(Objects obj) {
        this.obj = obj;
    }
}

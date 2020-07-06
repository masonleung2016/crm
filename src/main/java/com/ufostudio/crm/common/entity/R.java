package com.ufostudio.crm.common.entity;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据封装类
 *
 * @Author: LCF
 * @Date: 2020/7/5 17:41
 * @Package: com.ufostudio.crm.common.entity
 */


@ApiModel (value = "接口返回对象", description = "")
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("status", 0);
    }

    public static R error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static R error(int status, String msg) {
        R r = new R();
        r.put("status", status);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Object msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

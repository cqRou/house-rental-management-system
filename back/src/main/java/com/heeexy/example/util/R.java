package com.heeexy.example.util;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
    }

    public static R error2(String msg) {
        return error(500, "服务器内部错误，请联系管理员 <-" + msg);
    }

    public static R error() {
        return error(500, "服务器内部错误，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R apiError(String code, String msg,String enmsg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        r.put("enmsg", enmsg);
        return r;
    }


    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        r.put("code", 0);
        Map<String, Object> map = new HashMap<>();
        r.put("data", map);
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
}

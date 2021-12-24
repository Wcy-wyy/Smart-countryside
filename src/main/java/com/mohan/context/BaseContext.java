package com.mohan.context;

import com.alibaba.fastjson.JSONObject;
import com.mohan.constant.LoginConstants;
import com.mohan.module.auth.user.domain.SysUser;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseContext {


    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static void setUser(SysUser user) {
        set("user", user);
    }


    public static SysUser getUser() {
        Object user = get("user");
        if (!ObjectUtils.isEmpty(user)) {
            return JSONObject.parseObject(JSONObject.toJSONString(user), SysUser.class);
        }
        return null;
    }

    public static void setAuthKey(String value) {
        set(LoginConstants.AUTH_KEY, value);
    }

    public static String getAuthKey() {
        return ObjectUtils.isEmpty(get(LoginConstants.AUTH_KEY)) ? null : get(LoginConstants.AUTH_KEY).toString();
    }
}

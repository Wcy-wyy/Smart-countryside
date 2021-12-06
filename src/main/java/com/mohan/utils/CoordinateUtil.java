package com.mohan.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class CoordinateUtil {
    public static void main(String[] args) {
        @Data
        class geocode {
            private String formatted_address;
            private String hospital;
            private String country;
            private String province;
            private String city;
            private String district;
            private String location;
        }

        List<String> list = new ArrayList<>();;
        list.add("");
        for (String s : list) {
            String trim = s.trim();
            HttpRequest request = HttpUtil.createGet("https://restapi.amap.com/v3/geocode/geo" + "?address="+ trim +"&city=嘉兴&key=0284c5735392656fb6be16df2ec862c0");
            String result = request.execute().body();
            JSONObject jsonObject = JSONObject.parseObject(result);
            List<geocode> geocodes = JSONObject.parseArray(JSONObject.toJSONString(jsonObject.get("geocodes")), geocode.class);
            geocodes.forEach(geocode -> geocode.setHospital(trim));
            String location;
            if (CollectionUtil.isEmpty(geocodes)) {
                System.out.println("null");
                continue;
            }
            location = geocodes.get(0).getLocation();
            System.out.println(location);
        }
    }
}

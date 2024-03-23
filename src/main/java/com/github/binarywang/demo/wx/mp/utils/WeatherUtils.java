package com.github.binarywang.demo.wx.mp.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import java.util.HashMap;
import java.util.Map;

public class WeatherUtils {

    public WeatherUtils() {
    }

    public static String getWeather(String city) {
        Map<String, Object> param = new HashMap(16);
        param.put("city", "昆明");
        param.put("key", "8ea4608f27b307c686741e86256d0456");
        String info = HttpUtil.get("http://apis.juhe.cn/simpleWeather/query", param);
        JSONObject jsonObject = JSONUtil.parseObj(info);
        JSONObject result = jsonObject.getJSONObject("result");
        JSONObject realtime = result.getJSONObject("realtime");
        return "૮  ´͈ ᗜ `͈ ა♡ " + result.get("city") + "天气播报~\r\n♡♡♡♡♡♡♡♡♡♡\r\n今日天气 |"
            + realtime.get("info") + "|\r\n气度  " + realtime.get("temperature") + "℃\r\n空气质量 "
            + realtime.get("aqi") + "\r\n湿度  " + realtime.get("humidity") + "%\r\n♡♡♡♡♡♡♡♡♡♡\r\n";
    }
}

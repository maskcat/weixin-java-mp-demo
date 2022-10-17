package com.github.binarywang.demo.wx.mp.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.binarywang.demo.wx.mp.constant.ApiConst;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;

/**
 * @author fymas
 */
@Log4j2
public class ConstellationUtils {

    public static String getConstellation(String consName) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("consName", consName);
        param.put("type", "today");
        param.put("key", ApiConst.CONS_KEY);
        String info = HttpUtil.get(ApiConst.CONS_URL, param);
        //String info = "{\"date\":20221015,\"name\":\"双子座\",\"QFriend\":\"双子座\",\"color\":\"天蓝色\",\"datetime\":\"2022年10月15日\",\"health\":\"80\",\"love\":\"75\",\"work\":\"75\",\"money\":\"85\",\"number\":4,\"summary\":\"运势相当不错，或能心想事成。比较主动出击的一天，你能够抓住挑战的机会，通过全新的尝试，找到现状的突破口。生活方面越是得到别人的捧场，就越有分享欲，善于发现身边的美好。\",\"all\":\"75\",\"resultcode\":\"200\",\"error_code\":0}";
        JSONObject jsonObject = JSONUtil.parseObj(info);
        return "------------" + "\r\n"
            + "今天是" + jsonObject.get("datetime") + "\r\n"
            + "------------" + "\r\n"
            + jsonObject.get("name") + "的你" + jsonObject.get("color") + "是你的幸运颜色，今日运势~" + "\r\n"
            + "------------" + "\r\n"
            + "爱情运势：" + jsonObject.get("love") + "\r\n"
            + "事业运势：" + jsonObject.get("work") + "\r\n"
            + "健康运势：" + jsonObject.get("health") + "\r\n"
            + "------------" + "\r\n"
            + "运势总结：" + jsonObject.get("summary") + jsonObject.get("summary") + "\r\n";
    }

}

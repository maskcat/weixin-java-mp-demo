
package com.github.binarywang.demo.wx.mp.utils;

import java.time.LocalDate;

public class AnniversaryUtils {

    public static String getLoveDay() {
        LocalDate loveDay = LocalDate.parse("2020-03-01");
        LocalDate now = LocalDate.now();
        int day = (int) (now.toEpochDay() - loveDay.toEpochDay());
        int years = day / 365;
        int daysInYear = isLeapYear(years) ? 366 : 365;
        int months = (day % daysInYear) / 30;
        int daysLeft = (day % daysInYear) % 30;
        return "------------\r\n亲爱的小羊羊~今天是我们恋爱" + years + "年" + months + "月"
            + daysLeft + "天的日子૮₍⑅˶•▿•˶⑅₎ა";
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}

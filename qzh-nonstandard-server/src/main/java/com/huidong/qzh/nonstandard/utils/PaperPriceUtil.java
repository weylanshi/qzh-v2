package com.huidong.qzh.nonstandard.utils;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class PaperPriceUtil {

    public static Double getPaperPrice(Double basePrice, String paperClass, Integer paperNum) {

        int g = 1;
        switch (paperClass) {
            case "150克":
                g = 150;
                break;
            case "200克":
                g = 200;
                break;
            case "250克":
                g = 250;
                break;
        }
        double w = 1;
        double h = 1;
        switch (paperNum) {
            case 32:
                w = 0.21;
                h = 0.14;
                break;
            case 16:
                w = 0.21;
                h = 0.285;
                break;
            case 8:
                w = 0.42;
                h = 0.285;
                break;
            case 4:
                w = 0.42;
                h = 0.57;
                break;
        }


        return basePrice * g * w * h / Math.pow(10, 6);
    }

    /**
     * 根据长宽相乘字符串获取长宽
     *
     * @param WLStr
     * @return
     */
    public static Map<String, Double> getWithAndLenByStr(String WLStr) {
        if (StringUtils.isNotBlank(WLStr)) {
            String[] widthAndLen = WLStr.split("\\*");
            HashMap<String, Double> wl = new HashMap<>();
            wl.put("w", Double.valueOf(widthAndLen[0]));
            wl.put("l", Double.valueOf(widthAndLen[1]));
            return wl;
        } else {
            return null;
        }

    }

    /**
     * 根据纸张的尺寸获取开数
     * @param paperSize 210*140 mm*mm
     * @return
     */
    public static int getOpenBySize(String paperSize) {
        int open = 0;
        switch (paperSize) {
            case "210*140":
                open = 32;
                break;
            case "210*285":
                open = 16;
                break;
            case "420*285":
                open = 8;
                break;
            case "420*570":
                open = 4;
                break;
        }
        return open;
    }
}

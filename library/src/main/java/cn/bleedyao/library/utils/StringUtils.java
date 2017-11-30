package cn.bleedyao.library.utils;

import java.util.Locale;

/**
 * Created by yaoluhao on 29/11/2017.
 */

public class StringUtils {
    private StringUtils(){}

    public static String addValue(String format,Object...obj){
        return String.format(Locale.CHINA,format,obj);
    }
}

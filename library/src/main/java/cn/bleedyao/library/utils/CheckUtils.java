package cn.bleedyao.library.utils;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoluhao on 31/07/2017.
 */

public class CheckUtils {

    public static boolean checkViewContent(TextView... views) {
        boolean temp = false;
        for (int i = 0; i < views.length; i++) {
            if (TextUtils.isEmpty(views[i].getText().toString().trim())) {
                LogUtil.d(LogUtil.TAG, views[i].getClass().getSimpleName() + "is empty content");
                break;
            }
            if (i == views.length - 1) {
                LogUtil.d(LogUtil.TAG,"All of the view is not empty");
                temp = true;
            }
        }
        return temp;
    }

    /**
     * @auther YaoLuHao
     * create by 21/12/2017 11:18
     * 检索传入的对象，如果有空对象，则指出空对象的索引位置
     */
    public static void checkNotNulls(Object... objs) {
        List<Integer> nullObject = null;
        for (int i = 1; i < objs.length; i++) {
            if (objs[i] == null) {
                if (nullObject == null) {
                    nullObject = new ArrayList<>();
                }
                nullObject.add(i);
            }
        }
        if (nullObject != null) {
            throw new NullPointerException("The indexs of null point are: " + nullObject.toString
                    ());
        }
    }

    /**
     * @auther YaoLuHao
     * create by 21/12/2017 11:24
     * 检验传入对象的引用，如果是空对象，则抛出空指针异常
     */
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }

    /**
     * @auther YaoLuHao
     * create by 21/12/2017 11:26
     * 检验传入对象的引用，如果是空对象，则抛出异常信息
     */
    public static <T> T checkNotNull(T reference, @Nullable Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        } else {
            return reference;
        }
    }

    public static <T> T checkNotNull(T reference, @Nullable String errorMessageTemplate,
                                     @Nullable Object... errorMessageArgs) {
        if (reference == null) {
            throw new NullPointerException(format(errorMessageTemplate, errorMessageArgs));
        } else {
            return reference;
        }
    }

    private static String format(String template, @Nullable Object... args) {
        if (args == null) {
            args = new Object[0];
        }
        template = String.valueOf(template);
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;

        int i;
        int placeholderStart;
        for (i = 0; i < args.length; templateStart = placeholderStart + 2) {
            placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }

            builder.append(template.substring(templateStart, placeholderStart));
            builder.append(args[i++]);
        }

        builder.append(template.substring(templateStart));
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);

            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }

            builder.append(']');
        }

        return builder.toString();
    }
}

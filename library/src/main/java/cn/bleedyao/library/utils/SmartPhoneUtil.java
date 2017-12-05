package com.arcticwind.highrailway.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by yaoluhao on 13/11/2017.
 */

public class SmartPhoneUtil {
    private static final String TAG = "SmartPhoneUtil";

    public static String getIMEI(Context context) {
        @SuppressLint("MissingPermission")
        String Imei = ((TelephonyManager) context
                .getSystemService(TELEPHONY_SERVICE))
                .getDeviceId();
        LogUtil.d(TAG, Imei);
        return Imei;
    }
}

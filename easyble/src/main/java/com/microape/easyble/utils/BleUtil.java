package com.microape.easyble.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/**
 * Created by pengle on 2018-11-26.
 * email:pengle609@163.com
 */
public class BleUtil {

    private final String UNKNOWN_SSID = "<unknown ssid>";
    private Context mContext;
    private WifiManager mWifiManager;

    private BleUtil() {

    }

    private static class SingletonInstance {
        private static final BleUtil INSTANCE = new BleUtil();
    }

    public static BleUtil newInstance() {
        return SingletonInstance.INSTANCE;
    }

    public BleUtil initUtil(Context context, WifiManager mWifiManager) {
        this.mContext = context.getApplicationContext();
        this.mWifiManager = mWifiManager;
        return this;
    }


    // TODO: 2019/3/18 连接名称匹配
    public boolean isMatcheName(String wifiName){
        if (TextUtils.isEmpty(wifiName) || UNKNOWN_SSID.equals(wifiName)){
            return false;
        }

        if (wifiName.matches("^DS\\d{2}-\\d{10,}$")){
            return true;
        }else if (wifiName.matches("^\"DS\\d{2}-\\d{10,}\"$")){
            return true;
        }

        return false;
    }

}

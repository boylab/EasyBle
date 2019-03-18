package com.microape.easyble.callback;

/**
 * Created by pengle on 2018-06-28.
 * email:pengle609@163.com
 */

public interface OnBleConnCallBack {

    void onBleConnectFail();

    //设备
    void onBleConnected();

    void onBleDisConnected();

}

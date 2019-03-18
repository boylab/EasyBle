package com.microape.easyble.callback;

import android.bluetooth.BluetoothDevice;

/**
 * Created by pengle on 2018-09-13.
 * email:pengle609@163.com
 */

public interface OnBleScanCallBack {

    void onBleDiscoveryStarted();

    void onBleFound(BluetoothDevice device);

    /*void onSearchStarted();

    void onSearchFound(BluetoothDevice device);*/

    void onBleDiscoveryFinished();

}

package com.microape.easyble.common.callback;

import android.bluetooth.BluetoothDevice;

import com.microape.easyble.receiver.BleStatus;

/**
 *  * Author：pengl on 2019/3/13 15:18
 *  * Email ：pengle609@163.com
 *  
 */
public class BleAdapter {

    private BleStatus bleStatus;
    private OnBleOpenCallBack onBleOpenCallBack;
    private OnBleScanCallBack onBleScanCallBack;
    private OnBleConnCallBack onBleConnCallBack;

    public BleAdapter(BleStatus bleStatus) {
        this.bleStatus = bleStatus;
    }

    public void setOnBleOpenCallBack(OnBleOpenCallBack onBleOpenCallBack) {
        this.onBleOpenCallBack = onBleOpenCallBack;
    }

    public void setOnBleScanCallBack(OnBleScanCallBack onBleScanCallBack) {
        this.onBleScanCallBack = onBleScanCallBack;
    }

    public void setOnBleConnCallBack(OnBleConnCallBack onBleConnCallBack) {
        this.onBleConnCallBack = onBleConnCallBack;
    }

    public void btStateOpen(){
        if (onBleOpenCallBack != null){
            onBleOpenCallBack.onBleEnable();
        }
        bleStatus.setEnabled(true);
    }

    public void btStateClose(){
        if (onBleOpenCallBack != null){
            onBleOpenCallBack.onBleDisable();
        }
        bleStatus.setEnabled(false);
    }

    public void btScanStarted(){
        if (onBleScanCallBack != null){
            onBleScanCallBack.onBleDiscoveryStarted();
        }
        bleStatus.setDiscovery(true);
    }

    public void btScanFound(BluetoothDevice device){
        if (onBleScanCallBack != null){
            onBleScanCallBack.onBleFound(device);
        }
    }

    public void btScanFinished(){
        if (onBleScanCallBack != null){
            onBleScanCallBack.onBleDiscoveryFinished();
        }
        bleStatus.setDiscovery(true);
    }

    public void btConnectFail(){
        if (onBleConnCallBack != null){
            onBleConnCallBack.onBleConnectFail();
        }
        bleStatus.setConn(false);
        //BleAction.setIsConnecting(false);
    }

    //设备
    public void btConnected(){
        if (onBleConnCallBack != null) {
            onBleConnCallBack.onBleConnected();
        }
        bleStatus.setConn(true);
        //BleAction.setIsConnecting(false);
    }

    public void btDisConnected(){
        if (onBleConnCallBack != null) {
            onBleConnCallBack.onBleDisConnected();
        }
        bleStatus.setConn(false);
        //BleAction.setIsConnecting(false);
    }

}

package com.microape.easyble;

import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.widget.Toast;

import com.microape.easyble.callback.OnBleConnCallBack;
import com.microape.easyble.callback.OnBleOpenCallBack;
import com.microape.easyble.callback.OnBleScanCallBack;
import com.microape.easyble.receiver.BleReceiverManager;
import com.microape.easyble.receiver.BleStatus;

public class EasyBle {

    private static volatile EasyBle instance = null;
    private Context context;
    private BluetoothAdapter btAdapter;
    private BleReceiverManager bleReceiverManager = new BleReceiverManager();

    //private BleUtil blueToothUtil;
    private EasyBle() {

    }

    private static class SingletonInstance {
        private static final EasyBle INSTANCE = new EasyBle();
    }

    public static EasyBle newInstance() {
        return SingletonInstance.INSTANCE;
    }

    @SuppressLint("MissingPermission")
    public EasyBle init(Application context){
        this.context = context.getApplicationContext();
        bleReceiverManager.registerReceiver(context);

        if (btAdapter == null){
            btAdapter = BluetoothAdapter.getDefaultAdapter();

            BleStatus.newInstance().setEnabled(btAdapter.isEnabled());
            BleStatus.newInstance().setDiscovery(btAdapter.isDiscovering());
        }
        return this;
    }

    public BleStatus btStatus() {
        return bleReceiverManager.getBTStatus();
    }

    public void setOpenCallBack(OnBleOpenCallBack onBleOpenCallBack) {
        bleReceiverManager.setOpenCallBack(onBleOpenCallBack);
    }

    public void setScanCallBack(OnBleScanCallBack onBleScanCallBack) {
        bleReceiverManager.setSearchCallBack(onBleScanCallBack);
    }

    public void setConnCallBack(OnBleConnCallBack onBleConnCallBack) {
        bleReceiverManager.setConnCallBack(onBleConnCallBack);
    }

    @SuppressLint("MissingPermission")
    public boolean isEnabled(){
        return btAdapter.isEnabled();
    }

    @SuppressLint("MissingPermission")
    public boolean isScaning(){
        return btAdapter.isDiscovering();
    }

    @SuppressLint("MissingPermission")
    public void enable(){
        if (!btAdapter.isEnabled()) {
            btAdapter.enable();
        }
    }

    @SuppressLint("MissingPermission")
    public void disable(){
        if (btAdapter.isEnabled()) {
            btAdapter.disable();
        }
    }

    @SuppressLint("MissingPermission")
    public void startDiscovery(){
        if (!btAdapter.isEnabled()){
            Toast.makeText(context, "请先打开WiFi！", Toast.LENGTH_SHORT).show();
            return;
        }

        if (btAdapter.isDiscovering()){
            Toast.makeText(context,"扫描已开启，勿重复开启！", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!btAdapter.isDiscovering()){
            boolean startScan = btAdapter.startDiscovery();
        }
    }

    @SuppressLint("MissingPermission")
    public void cancelDiscovery(){
        if (!btAdapter.isEnabled()){
            Toast.makeText(context, "请先打开WiFi！", Toast.LENGTH_SHORT).show();
            return;
        }

        if (btAdapter.isDiscovering()){
            btAdapter.cancelDiscovery();
        }

    }

    public boolean connDevice(BluetoothDevice bluetoothDevice){
        boolean isWiFiConn = false;
        try {
            // TODO: 2019/3/18 开启蓝牙连接，并建立通讯
            // TODO: 2019/3/18 开启蓝牙连接，并建立通讯
            // TODO: 2019/3/18 开启蓝牙连接，并建立通讯


            throw new InterruptedException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isWiFiConn;
    }
    
}

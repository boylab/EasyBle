package com.microape.easyble.receiver;

import android.content.Context;
import android.content.IntentFilter;

import com.microape.easyble.common.callback.BleAdapter;
import com.microape.easyble.common.callback.OnBleConnCallBack;
import com.microape.easyble.common.callback.OnBleOpenCallBack;
import com.microape.easyble.common.callback.OnBleScanCallBack;

/**
 * Created by pengle on 2018-11-23.
 * email:pengle609@163.com
 */
public class BleReceiverManager {

    private boolean registerTag = false;
    private BleStatus bleStatus = BleStatus.newInstance();
    private BleAdapter bleAdapter = new BleAdapter(bleStatus);
    private BleReceiver bleReceiver = new BleReceiver(bleAdapter);

    public BleReceiverManager() {

    }

    public void registerReceiver(Context context){
        if (registerTag){
            return;
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(BleAction.EXTRA_STATE);
        filter.addAction(BleAction.ACTION_STATE_CHANGED);

        filter.addAction(BleAction.ACTION_DISCOVERY_STARTED);
        filter.addAction(BleAction.ACTION_DISCOVERY_FINISHED);
        filter.addAction(BleAction.ACTION_FOUND);
        filter.addAction(BleAction.EXTRA_DEVICE);

        filter.addAction(BleAction.ACTION_ACL_CONNECTFAIL);
        filter.addAction(BleAction.ACTION_ACL_CONNECTED);
        filter.addAction(BleAction.ACTION_ACL_DISCONNECTED);
        context.registerReceiver(bleReceiver, filter);
        registerTag = true;
    }

    public BleStatus getBTStatus() {
        return bleStatus;
    }

    public void setOpenCallBack(OnBleOpenCallBack onBleOpenCallBack) {
        bleAdapter.setOnBleOpenCallBack(onBleOpenCallBack);
    }

    public void setSearchCallBack(OnBleScanCallBack onBleScanCallBack) {
        bleAdapter.setOnBleScanCallBack(onBleScanCallBack);
    }

    public void setConnCallBack(OnBleConnCallBack onBleConnCallBack) {
        bleAdapter.setOnBleConnCallBack(onBleConnCallBack);
    }

    public void unRegisterReceiver(){
        try {
            if (registerTag){
                // TODO: 2018-11-23 似乎不需要注销
                //unregisterReceiver(bleReceiver);
                registerTag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package com.microape.easyble.receiver;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.microape.easyble.common.callback.BleAdapter;

/**
 * Created by pengle on 2018-09-13.
 * email:pengle609@163.com
 *
 */

public class BleReceiver extends BroadcastReceiver {

    private BleAdapter bleAdapter;

    public BleReceiver(BleAdapter BleAdapter) {
        this.bleAdapter = BleAdapter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (BleAction.ACTION_STATE_CHANGED.equals(action)) {
            int state = intent.getIntExtra(BleAction.EXTRA_STATE, -1);
            switch (state) {
                case BluetoothAdapter.STATE_ON:
                    if (bleAdapter != null ){
                        bleAdapter.btStateOpen();
                    }
                    break;
                case BluetoothAdapter.STATE_OFF:
                    if (bleAdapter != null ){
                        bleAdapter.btStateClose();
                    }
                    break;
            }
        } else  if (BleAction.ACTION_DISCOVERY_STARTED.equals(action)) {
            if (bleAdapter != null ){
                bleAdapter.btScanStarted();
            }
        } else if (BleAction.ACTION_FOUND.equals(action)) {
            BluetoothDevice device = intent.getParcelableExtra(BleAction.EXTRA_DEVICE);
            if (bleAdapter != null ){
                bleAdapter.btScanFound(device);
            }
        }  else if (BleAction.ACTION_DISCOVERY_FINISHED.equals(action)) {
            if (bleAdapter != null ){
                bleAdapter.btScanFinished();
            }
        } else if (BleAction.ACTION_ACL_CONNECTFAIL.equals(action)) {
            if (bleAdapter != null ){
                bleAdapter.btConnectFail();
            }
        } else  if (BleAction.ACTION_ACL_CONNECTED.equals(action)) {
            if (bleAdapter != null ){
                bleAdapter.btConnected();
            }
        }else if (BleAction.ACTION_ACL_DISCONNECTED.equals(action)) {
            if (bleAdapter != null ){
                bleAdapter.btDisConnected();
            }
        }
    }

}

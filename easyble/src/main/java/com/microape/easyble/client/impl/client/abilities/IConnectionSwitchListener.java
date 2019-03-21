package com.microape.easyble.client.impl.client.abilities;

import com.microape.easyble.client.sdk.client.ConnectionInfo;
import com.microape.easyble.client.sdk.client.connection.IConnectionManager;

/**
 * Created by xuhao on 2017/6/30.
 */

public interface IConnectionSwitchListener {
    void onSwitchConnectionInfo(IConnectionManager manager, ConnectionInfo oldInfo, ConnectionInfo newInfo);
}

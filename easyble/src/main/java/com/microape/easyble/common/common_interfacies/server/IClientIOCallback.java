package com.microape.easyble.common.common_interfacies.server;

import com.microape.easyble.core.iocore.interfaces.ISendable;
import com.microape.easyble.core.pojo.OriginalData;

public interface IClientIOCallback {

    void onClientRead(OriginalData originalData, IClient client, IClientPool<IClient, String> clientPool);

    void onClientWrite(ISendable sendable, IClient client, IClientPool<IClient, String> clientPool);

}

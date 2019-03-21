package com.microape.easyble.common.common_interfacies.server;

import com.microape.easyble.core.iocore.interfaces.IIOCoreOptions;

public interface IServerManagerPrivate<E extends IIOCoreOptions> extends IServerManager<E> {
    void initServerPrivate(int serverPort);
}

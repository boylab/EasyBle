package com.microape.easyble.common.common_interfacies.server;

import com.microape.easyble.common.common_interfacies.client.IDisConnectable;
import com.microape.easyble.common.common_interfacies.client.ISender;
import com.microape.easyble.core.protocol.IReaderProtocol;

import java.io.Serializable;

public interface IClient extends IDisConnectable, ISender<IClient>, Serializable {

    String getHostIp();

    String getHostName();

    String getUniqueTag();

    void setReaderProtocol(IReaderProtocol protocol);

    void addIOCallback(IClientIOCallback clientIOCallback);

    void removeIOCallback(IClientIOCallback clientIOCallback);

    void removeAllIOCallback();

}

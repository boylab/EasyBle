package com.microape.easyble.receiver;

/**
 * Created by pengle on 2018-11-23.
 * email:pengle609@163.com
 */
public class BleStatus {

    private boolean isEnabled = false;

    private boolean isDiscovery = false;

    private boolean isConn = false;

    private BleStatus() {

    }

    private static class SingletonInstance {
        private static final BleStatus INSTANCE = new BleStatus();
    }

    public static BleStatus newInstance() {
        return SingletonInstance.INSTANCE;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        if (!enabled){
            setDiscovery(false);
            setConn(false);
        }
        isEnabled = enabled;
    }

    public boolean isDiscovery() {
        return isDiscovery;
    }

    public void setDiscovery(boolean discovery) {
        if (discovery){
            setConn(false);
        }
        isDiscovery = discovery;
    }

    public boolean isConn() {
        return isConn;
    }

    public void setConn(boolean conn) {
        if (conn){
            setDiscovery(false);
        }
        isConn = conn;
    }

}

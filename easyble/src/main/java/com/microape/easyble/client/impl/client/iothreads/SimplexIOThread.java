package com.microape.easyble.client.impl.client.iothreads;

import com.microape.easyble.client.impl.exceptions.ManuallyDisconnectException;
import com.microape.easyble.client.sdk.client.action.IAction;
import com.microape.easyble.common.basic.AbsLoopThread;
import com.microape.easyble.core.iocore.interfaces.IReader;
import com.microape.easyble.core.iocore.interfaces.IStateSender;
import com.microape.easyble.core.iocore.interfaces.IWriter;
import com.microape.easyble.core.utils.SLog;

import java.io.IOException;

/**
 * Created by xuhao on 2017/5/17.
 */

public class SimplexIOThread extends AbsLoopThread {
    private IStateSender mStateSender;

    private IReader mReader;

    private IWriter mWriter;

    private boolean isWrite = false;


    public SimplexIOThread(IReader reader,
                           IWriter writer, IStateSender stateSender) {
        super("client_simplex_io_thread");
        this.mStateSender = stateSender;
        this.mReader = reader;
        this.mWriter = writer;
    }

    @Override
    protected void beforeLoop() throws IOException {
        mStateSender.sendBroadcast(IAction.ACTION_WRITE_THREAD_START);
        mStateSender.sendBroadcast(IAction.ACTION_READ_THREAD_START);
    }

    @Override
    protected void runInLoopThread() throws IOException {
        isWrite = mWriter.write();
        if (isWrite) {
            isWrite = false;
            mReader.read();
        }
    }

    @Override
    public synchronized void shutdown(Exception e) {
        mReader.close();
        mWriter.close();
        super.shutdown(e);
    }

    @Override
    protected void loopFinish(Exception e) {
        e = e instanceof ManuallyDisconnectException ? null : e;
        if (e != null) {
            SLog.e("simplex error,thread is dead with exception:" + e.getMessage());
        }
        mStateSender.sendBroadcast(IAction.ACTION_WRITE_THREAD_SHUTDOWN, e);
        mStateSender.sendBroadcast(IAction.ACTION_READ_THREAD_SHUTDOWN, e);
    }
}

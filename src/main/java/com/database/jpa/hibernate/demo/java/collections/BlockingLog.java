package com.database.jpa.hibernate.demo.java.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface BlockingLog
{
    public void start(String id);

    public void end(String id);

    public void poll();
}

class BlockLogImplementor implements BlockingLog
{

    Lock lock = new ReentrantLock();

    @Override
    public void start(String id) {

    }

    @Override
    public void end(String id) {
        lock.unlock();
    }

    @Override
    public void poll() {

    }
}

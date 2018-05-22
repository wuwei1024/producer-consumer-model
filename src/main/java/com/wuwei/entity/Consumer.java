package com.wuwei.entity;

/**
 * 消费者
 *
 * @author wuwei
 * @date 2018/5/22 9:59
 */
public class Consumer extends Thread {
    private String consumer;
    private Storage storage;

    public Consumer(String consumer, Storage storage) {
        this.consumer = consumer;
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.consume(consumer);
    }
}

package com.wuwei.entity;

/**
 * 生产者
 *
 * @author wuwei
 * @date 2018/5/22 9:51
 */
public class Producer extends Thread {
    private String producer;
    private Storage storage;

    public Producer(String producer, Storage storage) {
        this.producer = producer;
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.produce(producer);
    }
}

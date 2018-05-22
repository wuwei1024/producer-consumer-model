package com.wuwei.awaitSignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 生产者
 *
 * @author wuwei
 * @date 2018/5/22 12:02
 */
public class Producer {
    private static final Lock LOCK = Storage.getLock();
    private static final Condition FULL = Storage.getFullCondition();
    private static final Condition EMPTY = Storage.getEmptyCondition();

    private String producer;

    public Producer(String producer) {
        this.producer = producer;
    }

    // 生产产品
    public void produce() {
        LOCK.lock();
        try {
            // 如果仓库已满
            while (Storage.isFull()) {
                System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
                // 生产阻塞
                FULL.await();
            }
            // 生产产品
            Storage.add(new Object());
            System.out.println("【" + producer + "】：生产了一个产品	【现仓储量为】:" + Storage.size());
            EMPTY.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            LOCK.unlock();
        }
    }
}

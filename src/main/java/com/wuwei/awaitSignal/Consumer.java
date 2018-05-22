package com.wuwei.awaitSignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 消费者
 *
 * @author wuwei
 * @date 2018/5/22 12:02
 */
public class Consumer {
    private static final Lock LOCK = Storage.getLock();
    private static final Condition FULL = Storage.getFullCondition();
    private static final Condition EMPTY = Storage.getEmptyCondition();

    private String consumer;

    public Consumer(String consumer) {
        this.consumer = consumer;
    }

    // 消费产品
    public void consume() {
        // 获得锁
        LOCK.lock();
        try {
            // 如果仓库存储量不足
            while (Storage.isEmpty()) {
                System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
                // 消费阻塞
                EMPTY.await();
            }
            Storage.remove();
            System.out.println("【" + consumer + "】：消费了一个产品	【现仓储量为】:" + Storage.size());
            FULL.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            LOCK.unlock();
        }
    }
}

package com.wuwei.test;

import com.wuwei.entity.Consumer;
import com.wuwei.entity.Producer;
import com.wuwei.entity.Storage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuwei
 * @date 2018/5/22 9:50
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer producer1 = new Producer("producer1", storage);
        Producer producer2 = new Producer("producer2", storage);
        Producer producer3 = new Producer("producer3", storage);

        Consumer consumer1 = new Consumer("consumer1", storage);
        Consumer consumer2 = new Consumer("consumer2", storage);
        Consumer consumer3 = new Consumer("consumer3", storage);

        //可变长度线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        int count = 0;
        while (count < 10000) {
            count++;
            cachedThreadPool.execute(consumer1);
            cachedThreadPool.execute(consumer2);
            cachedThreadPool.execute(consumer3);
            cachedThreadPool.execute(producer1);
            cachedThreadPool.execute(producer2);
            cachedThreadPool.execute(producer3);
        }
    }
}

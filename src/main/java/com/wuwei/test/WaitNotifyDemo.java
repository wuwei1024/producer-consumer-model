package com.wuwei.test;

import com.wuwei.entity.Consumer;
import com.wuwei.entity.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuwei
 * @date 2018/5/22 9:50
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        Producer producer1 = new Producer("producer1");
        Producer producer2 = new Producer("producer2");
        Producer producer3 = new Producer("producer3");
        Consumer consumer1 = new Consumer("consumer1");
        Consumer consumer2 = new Consumer("consumer2");
        Consumer consumer3 = new Consumer("consumer3");
        //可变长度线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        int count = 0;
        while (count < 10000) {
            cachedThreadPool.execute(consumer1::consume);
            cachedThreadPool.execute(consumer2::consume);
            cachedThreadPool.execute(consumer3::consume);
            cachedThreadPool.execute(producer1::produce);
            cachedThreadPool.execute(producer2::produce);
            cachedThreadPool.execute(producer3::produce);
            count++;
        }
    }
}

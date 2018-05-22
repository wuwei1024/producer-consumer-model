package com.wuwei.waitNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuwei
 * @date 2018/5/22 9:50
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {
        //可变长度线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        int count = 0;
        while (count < 10000) {
            cachedThreadPool.execute(new Consumer("consumer" + count)::consume);
            cachedThreadPool.execute(new Producer("producer" + count)::produce);
            count++;
        }
    }
}

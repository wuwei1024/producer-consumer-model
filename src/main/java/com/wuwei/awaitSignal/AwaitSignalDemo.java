package com.wuwei.awaitSignal;

/**
 * @author wuwei
 * @date 2018/5/22 14:44
 */
public class AwaitSignalDemo {

    public static void main(String[] args) {
        int count = 0;
        while (count < 10000) {
            new Thread(new Consumer("consumer" + count)::consume).start();
            new Thread(new Producer("producer" + count)::produce).start();
            count++;
        }
    }
}

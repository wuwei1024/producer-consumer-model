package com.wuwei.blockingQueue;

/**
 * 消费者
 *
 * @author wuwei
 * @date 2018/5/22 14:59
 */
public class Consumer {
    private String consumer;

    public Consumer(String consumer) {
        this.consumer = consumer;
    }

    // 消费产品
    public void consume() {
        // 如果仓库存储量不足
        if (Storage.isEmpty()) {
            System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
        }
        // 消费产品
        try {
            Storage.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + consumer + "】：消费了一个产品	【现仓储量为】:" + Storage.size());
    }
}

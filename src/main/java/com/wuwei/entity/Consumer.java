package com.wuwei.entity;

/**
 * 消费者
 *
 * @author wuwei
 * @date 2018/5/22 9:59
 */
public class Consumer {
    private String consumer;

    public Consumer(String consumer) {
        this.consumer = consumer;
    }

    // 消费产品
    public void consume() {
        synchronized (Storage.class) {
            // 如果仓库存储量不足
            while (Storage.isEmpty()) {
                System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
                try {
                    // 消费阻塞
                    Storage.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Storage.remove();
            System.out.println("【" + consumer + "】：消费了一个产品	【现仓储量为】:" + Storage.size());
            Storage.class.notifyAll();
        }
    }
}

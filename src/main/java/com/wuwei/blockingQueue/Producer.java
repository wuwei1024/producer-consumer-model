package com.wuwei.blockingQueue;

/**
 * 生产者
 *
 * @author wuwei
 * @date 2018/5/22 15:01
 */
public class Producer {
    private String producer;

    public Producer(String producer) {
        this.producer = producer;
    }

    // 生产产品
    public void produce() {
        // 如果仓库已满
        if (Storage.isFull()) {
            System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
        }
        // 生产产品
        try {
            Storage.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + producer + "】：生产了一个产品	【现仓储量为】:" + Storage.size());
    }
}

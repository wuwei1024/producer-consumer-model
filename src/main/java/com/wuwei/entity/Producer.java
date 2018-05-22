package com.wuwei.entity;

/**
 * 生产者
 *
 * @author wuwei
 * @date 2018/5/22 9:51
 */
public class Producer {
    private String producer;

    public Producer(String producer) {
        this.producer = producer;
    }

    // 生产产品
    public void produce() {
        synchronized (Storage.class) {
            // 如果仓库已满
            while (Storage.isFull()) {
                System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
                try {
                    // 生产阻塞
                    Storage.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 生产产品
            Storage.add(new Object());
            System.out.println("【" + producer + "】：生产了一个产品	【现仓储量为】:" + Storage.size());
            Storage.class.notifyAll();
        }
    }
}

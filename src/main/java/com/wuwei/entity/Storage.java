package com.wuwei.entity;

import java.util.LinkedList;

/**
 * 存储仓库
 *
 * @author wuwei
 * @date 2018/5/22 9:52
 */
public class Storage {
    // 仓库最大存储量
    private static final int MAX_SIZE = 100;
    // 仓库存储的载体
    private static final LinkedList<Object> LIST = new LinkedList<Object>();

    // 生产产品
    public void produce(String producer) {
        synchronized (LIST) {
            // 如果仓库已满
            while (LIST.size() == MAX_SIZE) {
                System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
                try {
                    // 生产阻塞
                    LIST.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 生产产品
            LIST.add(new Object());
            System.out.println("【" + producer + "】：生产了一个产品	【现仓储量为】:" + LIST.size());
            LIST.notifyAll();
        }
    }

    // 消费产品
    public void consume(String consumer) {
        synchronized (LIST) {
            // 如果仓库存储量不足
            while (LIST.size() == 0) {
                System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
                try {
                    // 消费阻塞
                    LIST.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            LIST.remove();
            System.out.println("【" + consumer + "】：消费了一个产品	【现仓储量为】:" + LIST.size());
            LIST.notifyAll();
        }
    }
}


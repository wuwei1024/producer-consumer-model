package com.wuwei.awaitSignal;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wuwei
 * @date 2018/5/22 11:46
 */
public class Storage {
    // 仓库最大存储量
    private static final int MAX_SIZE = 100;
    // 仓库存储的载体
    private static final LinkedList<Object> LIST = new LinkedList<>();
    // 锁
    private static final Lock LOCK = new ReentrantLock();
    // 仓库满的条件变量
    private static final Condition FULL = LOCK.newCondition();
    // 仓库空的条件变量
    private static final Condition EMPTY = LOCK.newCondition();

    public static void add(Object object) {
        LIST.add(object);
    }

    public static void remove() {
        LIST.remove();
    }

    public static boolean isEmpty() {
        return LIST.isEmpty();
    }

    public static boolean isFull() {
        return LIST.size() == MAX_SIZE;
    }

    public static int size() {
        return LIST.size();
    }

    public static Lock getLock() {
        return LOCK;
    }

    public static Condition getFullCondition() {
        return FULL;
    }

    public static Condition getEmptyCondition() {
        return EMPTY;
    }
}

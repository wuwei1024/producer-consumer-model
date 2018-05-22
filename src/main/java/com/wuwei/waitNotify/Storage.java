package com.wuwei.waitNotify;

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
    private static final LinkedList<Object> LIST = new LinkedList<>();

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
}

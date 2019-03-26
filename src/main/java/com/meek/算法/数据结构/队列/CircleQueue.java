package com.meek.算法.数据结构.队列;

/**
 * 循环队列
 */
public class CircleQueue {
    //数组
    private String[] items;
    //数组大小
    private int n = 0;
    //队列头坐标
    private int head = 0;
    //队列尾坐标
    private int tail = 0;

    CircleQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @return
     */
    public boolean enqueue(String data) {
        //队列满了
        if ((tail + 1) % n == head) return false;
        items[tail] = data;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        //队列空了
        if (head == tail) return null;
        String result = items[head];
        head = (head + 1) % n;
        return result;
    }
}

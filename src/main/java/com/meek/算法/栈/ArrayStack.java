package com.meek.算法.栈;

/**
 * 用数组实现的栈叫顺序栈
 */
public class ArrayStack {
    private String[] items;//存放数据的数组
    private int count;//栈中元素个数
    private int n;//栈大小

    ArrayStack(int n) {
        this.n = n;
        items = new String[n];
        count = 0;
    }

    /**
     * 入栈
     *
     * @param data
     * @return
     */
    public boolean pull(String data) {
        if (count == n) return false;
        items[count] = data;
        ++count;
        return true;
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {
        if (count == 0) return null;
        String result = items[count - 1];
        --count;
        return result;
    }
}

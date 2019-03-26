package com.meek.算法.数据结构.队列;

/**
 * 顺序队列
 */
public class ArrayQueue {
    /**
     * 数组
     */
    private String[] items;
    //数组大小
    private int n = 0;
    //队列头坐标
    private int head = 0;
    //队列尾坐标
    private int tail = 0;

    ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队(含有数据搬移)
     * @return
     */
    public boolean enqueue(String data){

        //队列尾部没有空间了
        if(tail == n){
            //表示整个空间都慢了
            if(head == 0){
                return false;
            }
            //数据搬移
            for (int i = head;i<tail;++i){
                //前面是存放数据的位置,后面是要搬移数据的位置
                items[i-head] = items[i];
            }
            //搬移之后更新tail,head
            tail = tail - head;
            head = 0;
        }
        items[tail] = data;
        ++tail;
        return true;

       /* //队列满了
        if (tail == n) return false;
        items[tail] = data;
        ++tail;
        return true;*/
    }

    /**
     * 出队
     * @return
     */
    public String dequeue(){
        //队列空了
        if (head == tail) return null;
        String result = items[head];
        ++head;
        return result;
    }
}

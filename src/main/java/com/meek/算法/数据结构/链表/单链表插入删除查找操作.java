package com.meek.算法.数据结构.链表;

import com.meek.算法.数据结构.链表.LinkNode;

public class 单链表插入删除查找操作 {

    private LinkNode head = new LinkNode(1);

    /**
     * 查找
     *
     * @param value 要查找的值
     * @return
     */
    public LinkNode findByValue(int value) {
        LinkNode p = head;
        while (p != null && p.value != value) {
            p = p.next;
        }
        return p;
    }

    /**
     * 查找
     *
     * @param index 位置
     * @return
     */
    public LinkNode findByIndex(int index) {
        LinkNode p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    /**
     * 顺序插入
     * 链表尾部插入
     *
     * @param value
     */
    public void insertTail(int value) {
        LinkNode newNode = new LinkNode(value, null);
        if (head == null) {
            head = newNode;
        } else {
            LinkNode q = head;
            //找到最后一个点
            while (q.next != null) {
                q = q.next;
            }
            q.next = newNode;
        }
    }

    /**
     * 删除第一个是value的点
     *
     * @param value
     */
    public void deleteByValue(int value) {
        if (head == null) return;
        LinkNode p = head;
        LinkNode prev = null;
        //找到这个点
        while (p != null && p.value != value) {
            prev = p;
            p = p.next;
        }
        //边境情况;没找到这个点
        if (p == null) return;

        //第一个点就是要找到的点
        if (prev == null) {
            //将第一个点去掉
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }

    }

    /**
     * 删除所有是value的点
     *
     * @param value
     */
    public void deleteAllByValue(int value) {
        //处理第一个点
        if (head == null) return;
        //while 开始多个值都要删除
        while (head != null && head.value == value) {
            head = head.next;
        }
        LinkNode p = head;
        while (p != null) {
            if(p.next.value == value){
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
    }

}

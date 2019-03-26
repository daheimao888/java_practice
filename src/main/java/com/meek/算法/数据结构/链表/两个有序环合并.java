package com.meek.算法.数据结构.链表;

public class 两个有序环合并 {

    /**
     * 两个有序链表合并
     * @param listA
     * @param listB
     * @return
     */
    public LinkNode mergeSortedList(LinkNode listA,LinkNode listB){
        if (listA == null) return listB;
        if (listB == null) return listA;

        LinkNode a = listA;
        LinkNode b = listB;
        LinkNode head;
        if (a.value < b.value){
            head = a;
            a = a.next;
        }else {
            head = b;
            b = b.next;
        }
        LinkNode result = head;
        while (a != null && b!=null){
            if (a.value < b.value){
                result.next = a;
                a = a.next;
            }else {
                result.next = b;
                b = b.next;
            }
        }
        if(a != null){
            result.next = a;
        }else {
            result.next = b;
        }
        return result;
    }
}

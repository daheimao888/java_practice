package com.meek.算法.链表;

public class 检测环 {

    /**
     * 检测一个单向链表是否有环
     * @param head
     * @return
     */
    public boolean checkCircle(LinkNode head){
        if(head == null) return false;

        LinkNode fast = head.next;
        LinkNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    /**
     * 求中间节点
     *
     * @param head
     * @return
     */
    public LinkNode findMid(LinkNode head){
        if(head == null) return head;

        LinkNode fast = head;
        LinkNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

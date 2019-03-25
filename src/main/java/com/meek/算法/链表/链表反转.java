package com.meek.算法.链表;

/**
 * 单向链表反转
 */
public class 链表反转 {


    public LinkNode reverLinkNode(LinkNode head){

        LinkNode prev = null;
        while (head != null && head.next != null){

            LinkNode next = head.next;
            //将元素的下个节点设置成上一个节点
            head.next = prev;
            //将当下节点设置成前一个节点
            prev = head;
            //准备好下一次需要处理的节点
            head = next;
        }
        //处理单个节点情况或者是最后一个节点
        if(head != null){
            //将最后一个节点指向前一个节点
            head.next = prev;
        }

        return head;
    }
}

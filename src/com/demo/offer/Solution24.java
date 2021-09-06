package com.demo.offer;

public class Solution24 {
    /*反转链表
    思路：首先想到用递归；
     */
    public ListNode reverseList(ListNode head){
        if (head ==null || head.next == null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        newhead.next = head.next;
        head.next=null;
        //System.out.println(newhead.next.val);
        return newhead;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(11);
        ListNode node3 = new ListNode(12);
        ListNode node4 = new ListNode(13);
        ListNode node5 = new ListNode(14);
        ListNode node6 = new ListNode(15);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(solution24.reverseList(node1).val);
    }

}

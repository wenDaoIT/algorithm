package com.demo.offer;

import java.util.Stack;

public class Solution06 {
    public int[] resversePrint(ListNode head){
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int [] num = new int[stack.size()];
        while (!stack.isEmpty()){
            for (int i = 0; i <num.length; i++) {
                num[i] = stack.pop();
            }
        }
        return num;
    }
    public static void main(String[] args) {
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
        node6.next = null;
        Solution06 solution06 = new Solution06();
        for (int num : solution06.resversePrint(node1)){
            System.out.println(num);
        }

    }
}
class ListNode{
    public int val;
    public ListNode next;
    public ListNode( int val){
        this.val = val;
    }
}
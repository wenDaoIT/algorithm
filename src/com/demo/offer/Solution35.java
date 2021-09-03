package com.demo.offer;

public class Solution35 {
    public Node copyRandomList(Node head) {

        return head;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
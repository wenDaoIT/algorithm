package com.demo.offer;

public class Solution35 {

    //虚拟头节点
    Node dum = new Node(0);
    Node pre = dum;
    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null){
            //复制节点cur
            Node newnode = new Node(cur.val);
            dum.next = newnode;
            cur = cur.next;
            pre = newnode;
        }
        return dum.next;
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node0 = new Node(0);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        System.out.println(solution35.copyRandomList(node0).val);


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
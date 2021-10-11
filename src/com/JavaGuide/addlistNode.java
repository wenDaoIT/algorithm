package com.JavaGuide;

public class addlistNode {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
        addlistNode a =new addlistNode();
        ListNode sda = a.add(n1, n2);
        while (sda.next !=null){
            sda = sda.next;
            System.out.println(sda.val);
        }

    }
    public ListNode add(ListNode n1,ListNode n2){
        //
        ListNode newdump = new ListNode(0);
        ListNode q=n1,p=n2,cur=newdump;
        int carry =0;
        while(p!=null || q !=null){
            int x = p== null ? 0:p.val;
            int y = q== null ? 0:q.val;
            int sum = x + y+carry;
            carry = sum/10;

            cur.next = new ListNode(sum%10);
            cur = cur.next;
            if (p!=null)p=p.next;
            if (q!=null)q=q.next;
        }
        if (carry>0){
            cur.next=new ListNode(carry);
        }
        System.out.println(newdump.next.val);
        return newdump.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}

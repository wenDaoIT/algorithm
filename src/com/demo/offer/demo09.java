package com.demo.offer;

import java.util.Stack;

public class demo09 {
    private Stack<Integer> A;
    private Stack<Integer> B;

    public demo09(){
        A = new Stack<>();
        B = new Stack<>();
    }
    public void appendTail(int value){
        A.push(value);
    }

    public int deleteHead() {
        if (A.empty() && B.empty()) {
            return -1;
        } else {
            if (B.empty()) {
                while (!A.empty()) {
                    B.push(A.pop());
                }
            }
            return B.pop();
        }
    }

    public static void main(String[] args) {
        demo09 D = new demo09();

        //
        for (int i = 0; i <=10; i++) {
            D.appendTail(i);
            System.out.println("将"+i+"放入队列");

        }
        System.out.println();
        for (int i = 0; i <=11; i++) {

            System.out.println("取出"+D.deleteHead()+"个元素");
        }
    }
}


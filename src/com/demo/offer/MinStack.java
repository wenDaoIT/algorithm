package com.demo.offer;

import java.util.Stack;

public class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> dataStack;
    //date表示主栈 min表示辅助栈
    public MinStack(){
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }
    public void push(int x){
        dataStack.push(x);
        if (minStack.isEmpty() || minStack.peek()>x){
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }
    }
    public int top(){
        return dataStack.peek();
    }
    public void pop(){
        dataStack.pop();
        minStack.pop();
//        if (dataStack.pop() <= minStack.peek()){
//            minStack.pop();
//        }
    }
    public int min(){
        return minStack.peek();
    }
    //方法一 内存消耗较大
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(3);
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.min());

    }
}

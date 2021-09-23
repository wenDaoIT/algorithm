package com.demo;

public class BST前中后 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2,8,5};
        for (int num:nums){
            bst.add(num);
        }
        //////////////////
        //      5       //
        //    /   \     //
        //  3       6   //
        // / \      \  //
        //2   4       8 //
        //////////////////
        bst.inOrder();
        System.out.println();
    }
}

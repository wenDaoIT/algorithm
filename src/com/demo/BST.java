package com.demo;

public class BST<E extends Comparable<E>> {
        private class Node{
            public E e;
            public Node left,right;
            public Node (E e){
                this.e = e;
                left = null;
                right = null;
            }
        }
        //成员变量
        private Node root;
        private  int size;
        public BST(){
            //初始化变量
            root = null;
            size = 0;
        }
        //成员方法
        public int getSize(){
            return size;
        }
        public boolean isEmpty(){
            return size ==0 ;
        }

        public void add(E e){
            root = add(root,e);
        }

        //向以node为根节点的BST中插入元素e，递归算法
        private Node add(Node node, E e){
//            if (e.equals(node.e)){
//                return node;
//            }else if (e.compareTo(node.e) < 0 && node.left==null){
//                node.left = new Node(e);
//                size++;
//                return node;
//            }else if (e.compareTo(node.e) > 0 && node.right == null){
//                node.right = new Node(e);
//                size++;
//                return node;
//            }
            if (node == null){
                size++;
                return new Node(e);
            }

            if (e.compareTo(node.e)  <0) {
                node.left = add(node.left,e);
            } else if (e.compareTo(node.e)  > 0){
                node.right =add(node.right,e);
            }
            return node;
        }

        //查询操作是否包含e
        public boolean contains(E e){
            return contains(root,e);
        }
        private boolean contains(Node node,E e){
            if (node == null){
                return false;
            }
            if (e.compareTo(node.e) == 0 ){
                return true;
            }else if (e.compareTo(node.e) < 0){
                return contains(node.left,e);
            }
                return contains(node.right,e);
        }

        public void inOrder(){
            inOrder(root);
        }
        private void inOrder(Node node){
            if (node == null){
                return;
            }
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }

















}

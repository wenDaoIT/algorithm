package com.demo.offer;

public class Solution58 {
    //左旋字符串
    public static void main(String[] args) {
        String s="abcdefg";
        int k = 2;
        Fangfa1 f1 = new Fangfa1();
        System.out.println(f1.reverseLeftWords(s, k));
    }


}
//利用切片函数
class fangfa2{
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
class Fangfa1{
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i =0;i <n;i++){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}

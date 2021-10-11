package com;

import java.util.HashSet;
import java.util.Set;

public class TEST {
    /**
     * 统计字符串中的回文字符子串个数
     * @param s string字符串
     * @return int整型
     */
    public int cntPalindromicSubstrings (String s) {
        // write code here
        int count=0;
        if (s.length() == 1){
            return 1;
        }else {
            count = s.length();
        }
        for (int i = 0; i <s.length();i++) {

            for (int j = i+1; j <s.length(); j++) {
                if (s.charAt(i)==s.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        TEST test = new TEST();
        //aaa   abc   adsvsda
        System.out.println(test.cntPalindromicSubstrings("adsvsda"));
    }
}

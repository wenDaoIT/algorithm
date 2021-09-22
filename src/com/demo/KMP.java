package com.demo;
/*
给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "ABCDSABCDE";
        String str2 = "ABCDE";
        int [] next = KmpTable(str2);
        int index = kmpSearch(str1,str2,next);
        System.out.println(index);
    }
    //为字符串创建部分匹配表
    private static int[] KmpTable(String str){
        int[] next = new int[str.length()];
        for (int i = 1,j=0; i <str.length(); i++) {
            while (j>0 && str.charAt(i)!=str.charAt(j)){
                j= next[j-1];
            }
            if (str.charAt(i) == str.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
    /**
     *    //搜索算法
     * @param haystack 表示原来字符串
     * @param needle 子字符串
     * @param next 匹配表
     * @return
     */
    private static int kmpSearch(String haystack ,String needle,int[] next){
        for (int i = 0,j=0; i <haystack.length(); i++) {

        while (j>0 && haystack.charAt(i) != needle.charAt(j) ){
            //根据匹配表部分回溯
            j = next[j-1];
        }
        if (haystack.charAt(i) == needle.charAt(j)){
            //
            j++;
        }
        if(j == needle.length()){
            return i-j+1;
        }
        }
        return -1;
    }
}

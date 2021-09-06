package com.demo.offer;

public class Solution05 {
    public String replaceSpace(String s){
        int lenth = s.length();
        char[] array = new char[lenth*3];
        int size =0 ;
        for (int i = 0; i <lenth; i++) {
            char c =s.charAt(i);
            if (c==' '){
                array[size++]='%';
                array[size++] = '2';
                array[size++]= '0';
             }else {
                array[size++] = c;
            }

        }
        String newstring = new String(array,0,size);
        return newstring;
    }


    public static void main(String[] args) {
        String s = "we are family!";
        Solution05 solution05 =new Solution05();
        System.out.println(solution05.replaceSpace(s));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.replace2(s));
    }

}
//解法二：利用
class Solution2{
    public String replace2(String s){
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()){
            if ( c == ' '){
                res.append("%20");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}

package com.demo.Others;

public class jinzhizhuanhuan {
    public static void main(String[] args) {
        jinzhizhuanhuan tesy = new jinzhizhuanhuan();
        System.out.println(tesy.solve(48,5));
    }
    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve (int M, int N) {
        // write code here
        if(M == 0) return "0";//如果M=0就直接返回
        boolean flag = false;// 记录是不是负数
        if(M < 0){
            //如果是负数flag=true，M 取相反数
            flag = true;
            M = -M;
        }
        String jz ="0123456789ABCDEF";//对应进制的某一位
        StringBuffer res = new StringBuffer();//返回最终的结果
        while(M != 0){//就对应转换为N进制的逆序样子
            res.append(jz.charAt(M % N));
            M /= N;
        }
        res.reverse();//逆序一下才是对应的N进制
        if(flag) res.insert(0,"-");//如果是负数就在头位置插入一个-号
        return res.toString();
    }
}

package com.demo;
/*
大前提：因为书包初始容量大于0，物品也不会是0件，所以i，j,从1开始
 */
public class DynamicPlanning {
    public static void main(String[] args) {
        //物品的重量
        int[] w={1,4,3};
        //物品的价值
        int[] val={1500,3000,2000};
        //背包的容量
        int m=5;
        //  物品的个数
        int n=val.length;
        //v[i][j]表示在前i个物品能装入容量为J的背包的最大价格；
        int [][] v = new int[n+1][m+1];

        int [][] path = new int[n+1][m+1];
        //因为书包初始容量大于0，物品也不会是0件，所以i，j,从1开始
        for (int i = 1;i<v.length;i++){
            for (int j = 1; j <v[0].length; j++) {
                if (w[i-1]>j){
                    v[i][j] = v[i-1][j];
                }else {
//                    v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j]=v[i-1][j];

                    }
                }
            }
        }

        for (int i=0;i<v.length;i++){
            for (int j=0;j<v[i].length;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();

        }
//        System.out.println("===========================");
//        for (int i=0;i<path.length;i++){
//            for (int j=0;j<path[i].length;j++){
//                if (path[i][j]==1){
//                    System.out.printf("第%d个物品放入背包",i);
//                    System.out.println();
//                }
//            }
//        }
        //逆序
        int i = path.length-1;
        int j = path[0].length-1;
        while (i>0&& j >0){
            if (path[i][j] == 1){
                System.out.printf("第%d个物品放入背包",i);
                j -= w[i-1];
            }
            i--;
        }

    }
}

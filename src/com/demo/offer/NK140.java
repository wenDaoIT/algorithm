package com.demo.offer;

import java.util.Arrays;

//排序算法
public class NK140 {

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,6,4};
        NK140 n1 = new NK140();
//        for (int res : n1.MySort(arr)){
//            System.out.println(res);
//        }
//        n1.quickSort(arr, 0,arr.length-1);
//        for (int res:n1.quickSort(arr,0, arr.length-1)
//             ) {
//            System.out.println(res);
//        }
        int[] temp = new int[arr.length];
        for (int res : n1.mergeSort(arr,0, arr.length-1,temp)){
            System.out.println(res);
        }
    }
     //调用库函数Arrays.sort
     public int[] MySort (int[] arr) {
     Arrays.sort(arr);


     return arr;
     }
     //冒泡排序BubbleSort
     public int[] BubbleSort (int[] arr) {
     int x;
     for (int j = 0;j <arr.length-1; j++) {
         for (int i = 0; i <arr.length-1; i++) {
     if (arr[i]>arr[i+1]){
     x=arr[i];
     arr[i]=arr[i+1];
     arr[i+1]=x;
     }
     }
     }
     return arr;
     }
     public int[] quickSort(int[] list, int left, int right) {
     if (left < right) {
     // 分割数组，找到分割点
     int point = partition(list, left, right);
     // 递归调用，对左子数组进行快速排序
     quickSort(list, left, point - 1);
     // 递归调用，对右子数组进行快速排序
     quickSort(list, point + 1, right);
     }
     return list;
     }

     /**
     * 分割数组，找到分割点
     */
    public int partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }

            // 交换
            swap(list, left, right);

            while (left < right && list[left] <= first) {
                left++;
            }

            // 交换
            swap(list, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] mergeSort(int list[],int left,int right,int[] temp){
        if (left<right){
            //
            int mid = left+((right-left)>>1);
            //向左递归
            mergeSort(list,left,mid,temp);
            //向右递归
            mergeSort(list,mid+1,right,temp);
            //合并
            merge(list,left,mid,right,temp);
        }
        return list;
    }
    private void merge(int[] list,int left,int mid,int right,int[] temp){
        int t=0;//temp的当前索引
        int i=left;
        //新的右边界
        int r=mid+1;
        while (i<=mid && r<=right){
            if (list[i]<list[r]){
                temp[t++] = list[i++];
            }else {
                temp[t++] = list[r++];
            }

        }
        while (i<=mid){
            temp[t++] = list[i++];
        }
        while (r<=right){
            temp[t++] = list[r++];
        }
        t=0;
        int tempLeft =left;
        while (tempLeft<=right){
            list[tempLeft++] = temp[t++];
        }
    }
}



package com.demo.offer;

import java.util.Arrays;
// 输出没有顺序要求的   最小的 k 个数
public class Solution40 {
    public static void main(String[] args) {
        int array[]={5,4,6,8,3,1,5};
        int[] solution40 = new Solution40().quickSort(array,4,0, array.length-1);
        for (int res:solution40
             ) {
            System.out.println(res);
        }
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort(arr, k, 0, arr.length - 1);
    }
    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) {
            return quickSort(arr, k, l, i - 1);
        }
        if (i < k) {
            return quickSort(arr, k, i + 1, r);
        }
//        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

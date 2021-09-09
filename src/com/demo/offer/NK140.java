package com.demo.offer;

import java.util.Arrays;

//排序算法
public class NK140 {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 6, 4};
        NK140 n1 = new NK140();
//        for (int res : n1.MySort(arr)){
//            System.out.println(res);
//        }
//        n1.quickSort(arr, 0,arr.length-1);
//        for (int res:n1.quickSort(arr,0, arr.length-1)
//             ) {
//            System.out.println(res);
//        }
//        int[] temp = new int[arr.length];
//        for (int res : n1.mergeSort(arr,0, arr.length-1,temp)){
//            System.out.println(res);
//        }
        for (int res : n1.ShellSort(arr)) {
            System.out.println(res);

        }
    }

    //调用库函数Arrays.sort
    public int[] MySort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    //冒泡排序BubbleSort
    public int[] BubbleSort(int[] arr) {
        int x;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    x = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = x;
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

    public int[] mergeSort(int list[], int left, int right, int[] temp) {
        if (left < right) {
            //
            int mid = left + ((right - left) >> 1);
            //向左递归
            mergeSort(list, left, mid, temp);
            //向右递归
            mergeSort(list, mid + 1, right, temp);
            //合并
            merge(list, left, mid, right, temp);
        }
        return list;
    }

    private void merge(int[] list, int left, int mid, int right, int[] temp) {
        int t = 0;//temp的当前索引
        int i = left;
        //新的右边界
        int r = mid + 1;
        while (i <= mid && r <= right) {
            if (list[i] < list[r]) {
                temp[t++] = list[i++];
            } else {
                temp[t++] = list[r++];
            }

        }
        while (i <= mid) {
            temp[t++] = list[i++];
        }
        while (r <= right) {
            temp[t++] = list[r++];
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            list[tempLeft++] = temp[t++];
        }
    }

    private int[] SelectSort(int[] array) {
        //运行时间
        //13ms
        //占用内存
        //11504KB
        for (int i = 0; i < array.length; i++) {
            int index = i;
            //这里j=i+1 遍历过的就不用比较了
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            //加个判断
            if (index != i) {
                swap(array, i, index);
            }
        }
        return array;
    }

    private int[] SelectSortDG(int[] array, int index) {
        int min = index, i = index + 1;
        if (0 == array.length) {
            return null;
        }
        if (index == array.length) {
            System.out.println("判断");
            return null;
        }
        for (; i < array.length; i++) {
            if (array[min] > array[i]) {
                min = i;
            }
        }
        if (min != index) {
            swap(array, index, min);
        }
        SelectSortDG(array, ++index);
        return array;
    }


//    private int[] InsertSort(int array[]){
//        if (array == null){
//            return null;
//        }
//        for (int i = 1; i <array.length; i++) {
//            int j=i;
//            int temp = array[i];
//            for (; j >0; j--) {
//                if (array[j-1] > temp){
//                    array[j] = array[j-1];
//                }else {
//                    break;//此处很有必要，及时停止j--
//                }
//
//            }
//            //此时j是找到的插入位置，把较小的temp放到前面
//            array[j]=temp;
//        }
//        return array;
//    }
    //改成while
    private int[] InsertSort(int array[]){
        if (array == null){
            return null;
        }
        for (int i = 1; i <array.length; i++) {
            int j=i;
            int temp = array[i];
            while (j>0 && array[j-1]>temp){
                array[j] = array[j-1];
                j--;
            }
            //此时j是找到的插入位置，把较小的temp放到前面
            if (i!= j ){
                array[j]=temp;
            }
        }
        return array;
    }
    private int[] ShellSort(int array[]){
        int step = array.length >> 1 ;
        while (step>=1){
            for (int i = step; i < array.length; i++) {
                for (int j = i; j >=step; j-=step) {
                    if (array[j]<array[j-step]){
                        swap(array,j,j-step);
                    }else {
                        break;
                    }
                }
            }
            step >>= 1;
        }
        return array;
    }

}
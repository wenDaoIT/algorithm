package com.demo.offer;

import java.util.*;

public class MapSort {
    /**
     * 数组中出现次数第 k 多的数字（求次数前 k 多的问题）
     * 思路：创建一个map，key存放值，value 计数count
     */
    private int get(int array[],int k){
        //k代表次数
        Map<Integer,Integer> t1 = new HashMap<>();
        for (int i = 0; i <array.length; i++) {
            if (t1.containsKey(array[i])){
                int count = t1.get(array[i])+1;
                t1.put(array[i],count);
            }else {
                t1.put(array[i],1);
            }
        }
//        Set<Map.Entry<Integer,Integer>> entrySet = t1.entrySet();
        List<Map.Entry<Integer,Integer>> list =new ArrayList<Map.Entry<Integer,Integer>>(t1.entrySet());
        System.out.println(list);
        Collections.sort(list, new MapCompare());
        for (Map.Entry<Integer, Integer> res:list
             ) {
            System.out.println(res);
        }
        return list.get(k-1).getKey();
    }

    public static void main(String[] args) {
        int[] arr = {1,3,3,7,2,3,3,2,2,8};
        MapSort mapSort = new MapSort();
        System.out.println(mapSort.get(arr,1));

    }

    public void sort2(int array[],int k){
        int[] temp =new int[array.length];
        for (int i = 0; i <array.length; i++) {
            if (array[i] == i){
                temp[i] +=1;
            }
        }
        Arrays.stream(temp).sorted();
        for (int res:temp
             ) {
            System.out.println(res);
        }
    }
}
class MapCompare implements Comparator<Map.Entry<Integer, Integer>>{

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue()>o2.getValue()?o1.getValue():o2.getValue();
    }
}


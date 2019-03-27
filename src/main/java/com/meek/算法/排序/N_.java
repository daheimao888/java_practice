package com.meek.算法.排序;

import java.util.Arrays;

/**
 * 桶排序
 * 计数排序
 * 基数排序
 */
public class N_ {

    public static void main(String[] args) {
        System.out.println("初始数组: " + Arrays.toString(items));
        coutingSort();
    }

    private static int[] items = new int[]{1, 4, 5, 3, 6, 2, 42, 99, 63, 6, 4, 75, 67, 53, 234, 2, 56, 43, 22, 65, 75, 76};

    public static void coutingSort() {
        //找出桶的最大值
        int max = items[0];
        for (int i = 1; i < items.length; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }

        //创建桶并放入数据
        int[] bucket = new int[max + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }
        for (int i = 0; i < items.length; i++) {
            bucket[items[i]]++;
        }

        //依次累加
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] = bucket[i - 1] + bucket[i];
        }

        //排序,从后往前取值,越原来的值到桶中找位置,再放入到新数组中,同时保证相同数据的有序性不破坏,所以倒序来
        int[] temp = new int[items.length];
        for (int i = items.length - 1; i >= 0; i--) {
            int index = bucket[items[i]] - 1;
            temp[index] = items[i];
            bucket[items[i]]--;
        }
        System.out.println("排完序后的数组: " + Arrays.toString(temp));

        //排完序,赋值给越数组
        for (int i = 0; i < items.length; i++) {
            items[i] = temp[i];
        }
    }
}

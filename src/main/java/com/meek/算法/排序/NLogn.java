package com.meek.算法.排序;

import java.util.Arrays;

/**
 * 归并排序,快速排序
 */
public class NLogn {


    public static void main(String[] args) {
        //mergeSort();
        quickSort();
        System.out.println(Arrays.toString(items));
    }

    private static int[] items = new int[]{1, 4, 5, 3, 6, 2, 42, 3242, 63, 6, 4, 75, 67, 588768, 234, 2, 432, 43, 24577, 65, 75, 76};

    /**
     * ##############################################################################
     */
    private static int count = 1;

    /**
     * 归并排序,每次将数组分成两个分别排序,在进行合并成一个有序数组;
     */
    public static void mergeSort() {
        mergeSort_c(items, 0, items.length - 1);
    }

    /**
     * 归并排序-递归函数
     *
     * @param items 要排序的数组
     * @param p     第一个位置
     * @param r     最后一个位置
     */
    private static void mergeSort_c(int[] items, int p, int r) {
        //递归结束条件
        if (p >= r) return;
        //这里p+很重要
        int mid = p + (r - p) / 2;
        mergeSort_c(items, p, mid);
        mergeSort_c(items, mid + 1, r);
        //将两个有序数组合并一个有序数组
        merge(items, p, mid, r);
//        Arrays.copyOfRange()
    }

    /**
     * 将两个有序数组合并成一个有序数组
     *
     * @param items 合并后的数组
     * @param p     第一个位置
     * @param mid   中间位置
     * @param r     最后一个位置
     */
    private static void merge(int[] items, int p, int mid, int r) {
        //两个数组起始指针
        int i = p;
        int j = mid + 1;
        //排序结果的临时表
        int temp_k = 0;
        int[] temp = new int[r - p + 1];

        while (i <= mid && j <= r) {
            if (items[i] <= items[j]) {
                temp[temp_k++] = items[i++];
            } else {
                temp[temp_k++] = items[j++];
            }
        }

        //处理剩余数据
        while (i <= mid) {
            temp[temp_k++] = items[i++];
        }
        while (j <= r) {
            temp[temp_k++] = items[j++];
        }
        //拷贝到原来的数组
        for (int k = 0; k <= r - p; k++) {
            items[p + k] = temp[k];
        }
        System.out.println("合并第" + count++ + "次: " + Arrays.toString(items));
    }

    /**
     * ##############################################################################
     */

    /**
     * 快速排序-递归
     */
    public static void quickSort() {
        quickSort_c(items, 0, items.length - 1);
    }

    /**
     * 对数组进行分段,大的是一边,小的是一边,比较值取数组最后一个值,递归下去,达到整段数组排序的目的
     *
     * @param items
     * @param p
     * @param r
     */
    private static void quickSort_c(int[] items, int p, int r) {
        if (p >= r) return;
        //分开两段,split_index分开值索引,数组前面是小于该值的,后面是大于该值的
        int split_index = partition(items, p, r);
        //对每段再进行分段,已排过序的数据不排序了,否则会无限循环
        quickSort_c(items, p, split_index - 1);
        quickSort_c(items, split_index + 1, r);
    }

    /**
     * * 每次取最后一个数作为比较数(pivot 轴心)(可以随机取),将数组分为大于比较数和小于比较数两个数组,不可以用额外内存,只能数据搬移,将小的数换到小数数组的最后,
     * i 是 整段数组遍历下标,目的是判断每个数是否小于比较树,最后一个数因为是比较数,就不遍历它,单独最后处理
     * j 是 记录小数数组最后一个数的索引
     *
     * @param items
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] items, int p, int r) {
        int pivot = items[r];
        int i = p;
        int j = p;
        for (; i < r; i++) {
            if (items[i] < pivot) {
                //如果遍历的值和小数数组最后一个值相同,则直接比较下一个
                if (i == j) {
                    j++;
                    //break;
                } else {
                    int temp = items[j];
                    items[j++] = items[i];
                    items[i] = temp;
                }
            }
        }
        //最后一个比较数放到小数数组最后一个
        int temp = items[j];
        items[j] = items[r];
        items[r] = temp;
        System.out.println("分组第" + count++ + "次: " + Arrays.toString(items));
        return j;
    }
}

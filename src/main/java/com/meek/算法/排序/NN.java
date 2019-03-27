package com.meek.算法.排序;


import java.util.Arrays;

/**
 * 时间复杂度为(n*n:分别为:冒泡排序,插入排序,选择排序)
 */
public class NN {


    public static void main(String[] args) {
        //insertSort();
        //maopaoSort();
        selectSort();
        System.out.println(Arrays.toString(items));
    }

    private static int[] items = new int[]{1, 4, 5, 3, 6, 2,42,3242,63,6,4,75,67,588768,234,2,432,43,24577,65,75,76};

    /**
     * 冒泡排序:相邻位置数据交换,冒泡,每次把大的向后移,直到有序
     */
    public static void maopaoSort() {
        //冒泡次数
        for (int i = 0; i < items.length; i++) {
            boolean flag = false;
            //最后一个不需要冒泡,不需要拿出所以-1
            for (int j = 0; j < items.length - i - 1; j++) {
                if (items[j] > items[j+1]) {
                    int temp = items[j+1];
                    items[j+1] = items[j];
                    items[j] = temp;
                    flag = true;
                }
            }
            //如果没有数据交换,后面不需要冒泡了
            if (!flag) break;
        }
    }


    /**
     * 插入排序:未排序的数据向已排数据插入;第一个数据默认为已排序,顺序取出未排序的值,和前面已经排好的最后一个值比较,如果小,则向前移动数据,反之不移动,结束循环
     */
    public static void insertSort() {
        for (int i = 1; i < items.length; i++) {
            //要放入的值,数组第一个值默认已排好序
            int value = items[i];
            int j;
            //因为前面已经有序,所以倒着找要放入的位置
            for (j = i - 1; j >= 0; --j) {
                //如果前面数据比要放入的数据大
                if (items[j] > value) {
                    //将比较完的数据(大的数据)向后移动
                    items[j + 1] = items[j];
                } else {
                    //出现第一个小于放入的值,停止(因为前面的数据有序),找到了要插入的位置(比他小数据的后一个),
                    items[j + 1] = value;
                    break;
                }
            }
        }
    }


    /**
     * 选择排序:未排序的数据向已排数据插入;每次在未排序的值里面找到最小值,放入到已排序的后边
     */
    public static void selectSort() {
        //每次找一个,控制循环次数
        for (int i = 0; i < items.length-1; i++) {


            int minIndex = i;
            //记录
            for (int j = i +1;j< items.length;j++){
                if(items[j] < items[minIndex]){
                    //temp = items[j];
                    minIndex = j;
                }
            }
            //交换值
            int temp = items[i];
            items[i] = items[minIndex];
            items[minIndex] = temp;
        }
    }
}

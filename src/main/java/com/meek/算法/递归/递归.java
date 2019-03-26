package com.meek.算法.递归;

import java.util.HashMap;

public class 递归 {

    /**
     * 每次只能走一个或两个台阶,有多少种走法(分解每走一步,还有多少中算法)
     *
     * @param m 一共m个台阶
     * @return
     */
    public static int howManyRow(int m) {
        if (m == 1) return 1;
        if (m == 2) return 2;
        //走了一个台阶后有多种走法
        //走了两个台阶有多种走法
        return howManyRow(m - 1) + howManyRow(m - 2);
    }


    /**
     * 每次只能走一个或两个台阶,有多少种走法(分解每走一步,还有多少中算法)
     * 避免重复计算
     * @param m 一共m个台阶
     * @return
     */
    /*public static int howManyRow(int m) {
        if (m == 1) return 1;
        if (m == 2) return 2;
        //走了一个台阶后有多种走法
        //走了两个台阶有多种走法
        return howManyRow(m - 1) + howManyRow(m - 2);
    }*/

    public static void main(String[] args) {
        System.out.println(howManyRow(4));
    }
}

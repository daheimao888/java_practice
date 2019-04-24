package com.meek.算法.回溯;

/**
 * 功能描述: 回溯思想求解
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在背包最大重量限制下,背包中物品总重量最大值是多少?
 *
 * @author ljw
 * @create 2019-04-24
 */
public class 背包问题 {

    public static void main(String[] args) {
//        totalWeightInBackpack(0, 0);
        totalWeightInBackpack_1(0, 0);
        System.out.println(maxW);
    }

    // public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
    // cw 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
    // w 背包重量；items 表示每个物品的重量；n 表示物品个数
    // 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)

    /**
     * @param i     表示考察到哪个物品了
     * @param cw    表示当前已经装进去的物品的重量和
     * @param items 表示每个物品的重量
     * @param n     表示物品个数
     * @param w     背包重量
     */
    public void totalWeightInBackpack(int i, int cw, int[] items, int n, int w) {

        // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
        if (cw == w || i == n) {
            if (cw > maxW) maxW = cw;
            return;
        }
        //当前物品i重量items[i]不放在背包里
        totalWeightInBackpack(i + 1, cw, items, n, w);

        //当前物品放在背包里
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            totalWeightInBackpack(i + 1, cw + items[i], items, n, w);
        }
    }


    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
    private static int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
    private static int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private static int n = 5; // 物品个数
    private static int w = 9; // 背包承受的最大重量

    /**
     * @param i  表示考察到哪个物品了
     * @param cw
     */
    public static void totalWeightInBackpack(int i, int cw) { // 调用 f(0, 0)
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        totalWeightInBackpack(i + 1, cw); // 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            totalWeightInBackpack(i + 1, cw + weight[i]); // 选择装第 i 个物品
        }
    }

    // 备忘录，默认值 false,避免相同參數重复使用
    private static boolean[][] mem = new boolean[5][10];
    public static void totalWeightInBackpack_1(int i, int cw) { // 调用 f(0, 0)
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return; // 重复状态,计算过的,不进行重复回溯
        mem[i][cw] = true; // 记录 (i, cw) 这个状态
        totalWeightInBackpack_1(i + 1, cw); // 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            totalWeightInBackpack_1(i + 1, cw + weight[i]); // 选择装第 i 个物品
        }
    }


}

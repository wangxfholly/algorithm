package org.learn.dp;

public class Backpack {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[][] dp = new int[weight.length][bagWeight + 1];
        //初始化
        for (int i = weight[0]; i < bagWeight; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[weight.length - 1][bagWeight]);
    }
}

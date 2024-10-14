package org.learn.dp;

public class IntegerBreak {
    public int integerBreak(int n) {
        //dp[i]表示将数字i分割（至少分割成两部分）后得到的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, j * (i - j)));
            }
        }
        return dp[n];
    }
}

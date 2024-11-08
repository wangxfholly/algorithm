package org.learn.dp;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        //dp[i][0] 代表第i天持有股票的最大收益
        //dp[i][1] 代表第i天不持有股票的最大收益
        dp[0][0] = -prices[0];
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][0];
    }
}

package org.learn.dp;

public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        /**
         * 定义5种状态：
         * 0 没有操作 1第一次买入 2第一次卖出 3 第二次买入 4 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        //初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[len - 1][4];
    }
}

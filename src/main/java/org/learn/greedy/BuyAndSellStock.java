package org.learn.greedy;

public class BuyAndSellStock {

    public int maxProfit(int[] prices) {
        //找到一个最小的购入点
        int low = Integer.MIN_VALUE;
        //res 不断更新，直到数组循环完毕
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            res = Math.max(res, prices[i] - low);
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        //dp[i][0] 代表第i天持有股票的最大收益
        //dp[i][1] 代表第i天不持有股票的最大收益
        int[][] dp = new int[length][2];
        int result = 0;
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }
}

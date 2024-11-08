package org.learn.dp;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                res = Math.max(res, dp[i]);
            } else {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

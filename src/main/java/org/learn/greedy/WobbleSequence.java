package org.learn.greedy;

/**
 * <a href="https://leetcode.cn/problems/wiggle-subsequence/description/">摆动序列</a>
 */
public class WobbleSequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if (curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

/*    public int wiggleMaxLengthDp(int[] nums) {
        // 0 i 作为波峰的最大长度
        // 1 i 作为波谷的最大长度

        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = 1;

        for (int i = 1; i < nums.length; i++) {
            //i 自己可以成为波峰或者波谷
            dp[i][0] = dp[i][1] = 1;
        }
    }*/
}

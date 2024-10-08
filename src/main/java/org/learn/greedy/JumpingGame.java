package org.learn.greedy;

public class JumpingGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        //覆盖范围，初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(i + nums[i], coverRange);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

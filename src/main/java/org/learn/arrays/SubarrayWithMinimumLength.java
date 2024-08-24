package org.learn.arrays;

/**
 * 数组之长度最小的子数组
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/">数组之长度最小的子数组</a>
 *
 * @author holly
 */
public class SubarrayWithMinimumLength {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        int target = 7;
        int length = minSubArrayLen(target, nums);
        System.out.println(length);
    }

    /**
     * 滑动窗口
     *
     * @param target 目标和
     * @param nums   数组
     * @return 返回最小长度
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        //i是滑动窗口的结束位置
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                //找到了一个大于等于target的滑动窗口，此时计算长度
                result = Math.min(result, i - left + 1);
                //缩小滑动窗口并更新sum
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

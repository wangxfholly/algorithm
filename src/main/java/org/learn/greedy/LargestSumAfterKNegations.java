package org.learn.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //将数组按照绝对值大小从大到小排序，注意要按照绝对值大小
        nums = IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        //如果K还大于0，那么反复转变数值最小的元素，将K用完
        if (k % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();
    }

    /**
     * 版本二：排序数组并贪心地尽可能将负数转为正数，再根据剩余的k值调整最小元素的符号，从而最大化数组总和
     */
    public int largestSumAfterKNegations2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        Arrays.sort(nums);
        //贪心点，通过负转正,消耗尽可能多的k
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        //退出循环，k >0 || k <0(k消耗完了不用讨论)
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;

    }
}

package org.learn.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含n个整数的数组nums和一个目标值target，判断nums中是否存在四个元素a，b，c和d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。 答案中不可以包含重复的四元组
 *
 * @author holly
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        FourSum fourSum = new FourSum();
        List<List<Integer>> result = fourSum.fourSumCount(nums, target);
        System.out.println(result);

    }

    /**
     * 四数之和
     * @param nums 数组
     * @param target 目标和
     * @return List<List<Integer>> 四元组
     */
    public List<List<Integer>> fourSumCount(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //nums[i] > target 则直接返回 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //对nums[i]去重
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //nums[i] + nums[j] > target 则直接返回 剪枝操作
                if (nums[i] + nums[j] > 0 && nums[i] + nums[j] > target) {
                    return res;
                }
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    //对nums[j]去重
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //nums[i] + nums[j] + nums[left] + nums[right] > target int
                    Long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }

        }
        return res;
    }
}

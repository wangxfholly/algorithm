package org.learn.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定数组求两数之和的下标
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[1] = i;
                result[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}

package org.learn.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和 给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c，使得a + b + c = 0？请你找出所有和为0且不重复的三元组。
 * @author holly
 */
public class TreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        TreeSum treeSum = new TreeSum();
        List<List<Integer>> result = treeSum.threeSum(nums);
        System.out.println(result);
    }

    /**
     * 去重函数
     * @param nums
     * @return List<List<Integer>> 三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //找出a+b+c = 0
        //a = nums[i], b = nums[left], c = nums[right]
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑出三元组，直接返回结果就可以了
            if(nums[i] > 0){
                return result;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                //去重a
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                } else if(sum < 0){
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                        //去重逻辑应该放在找到一个三元组之后，对b和c去重
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}

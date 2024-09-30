package org.learn.backtrace;

import java.util.*;

public class UniqueFullArragement {
    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> uniqueFullArrangement(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        if (nums.length == 0) {
            return result;
        }

        Arrays.fill(visited, false);
        Arrays.sort(nums);
        permuteHelper(nums, visited);
        return result;
    }
    private void permuteHelper(int[] nums, boolean[] used) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //used[i-1] == true 说明同一树枝nums[i-1]使用过
            //used[i-1] == false 说明同一树层nums[i-1]使用过
            //如果同一树层nums[i-1]使用过则直接跳过
            if(i > 0 && nums[i] == nums[i-1] && used[i-1]) {
                continue;
            }
            if(used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                permuteHelper(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}

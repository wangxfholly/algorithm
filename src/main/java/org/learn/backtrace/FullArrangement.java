package org.learn.backtrace;

import java.util.*;

public class FullArrangement {
    /**
     * 存放符合条件结果的集合
     */
    List<List<Integer>> result = new ArrayList<>();
    /**
     * 用来存放符合条件结果
     */
    LinkedList<Integer> path = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> fullArrangement(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    private void permuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}

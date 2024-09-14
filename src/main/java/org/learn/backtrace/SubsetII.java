package org.learn.backtrace;

import java.util.*;

public class SubsetII {
    /**
     * 存放符合条件结果的集合
     */
    List<List<Integer>> result = new ArrayList<>();
    /**
     * 用来存放符合条件结果
     */
    LinkedList<Integer> path = new LinkedList<>();

    boolean[] visited;

    public List<List<Integer>> subsetWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        subsetWithDup(nums, 0);
        return result;
    }

    private void subsetWithDup(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            subsetWithDup(nums, i + 1);
            path.removeLast();
            visited[i] = false;
        }
    }
}

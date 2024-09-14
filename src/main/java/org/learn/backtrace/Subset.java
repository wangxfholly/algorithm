package org.learn.backtrace;

import java.util.*;

public class Subset {
    /**
     * 存放符合条件结果的集合
     */
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 用来存放符合条件的结果
     */
    List<Integer> path = new ArrayList<>();


    private void subsetsHelper(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

package org.learn.greedy;


import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int start = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                res.add(new int[]{start, right});
                start = intervals[i][0];
                right = intervals[i][1];
            } else {
                right = Math.max(right, intervals[i][1]);
            }
        }
        res.add(new int[]{start, right});
        return res.toArray(new int[0][]);
    }
}

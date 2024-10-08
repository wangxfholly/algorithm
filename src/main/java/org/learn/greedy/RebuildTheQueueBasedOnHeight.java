package org.learn.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class RebuildTheQueueBasedOnHeight {
    public int[][] rebuildQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[people.length][]);
    }
}

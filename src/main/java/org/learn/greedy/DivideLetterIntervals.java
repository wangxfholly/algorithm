package org.learn.greedy;


import java.util.*;

public class DivideLetterIntervals {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(edge[chars[i] - 'a'], idx);
            if (i == idx) {
                result.add(i - last);
                last = i;
            }
        }
        return result;
    }
}

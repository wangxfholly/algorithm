package org.learn.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加
 *
 * @author holly
 */
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : A) {
            for (int j : B) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i : C) {
            for (int j : D) {
                int sum = i + j;
                res += map.getOrDefault(-sum, 0);
            }
        }
        return res;
    }
}

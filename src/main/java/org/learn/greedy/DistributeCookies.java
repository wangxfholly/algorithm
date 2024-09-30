package org.learn.greedy;

import java.util.Arrays;

public class DistributeCookies {

    /**
     * 优先考虑饼干，小饼干先喂饱小胃口
     *
     * @param g 胃口
     * @param s 饼干
     */

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }
}

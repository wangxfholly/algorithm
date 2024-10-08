package org.learn.greedy;

import java.util.Arrays;

public class HandOutCandy {
    /**
     * 分两个阶段
     * 1.起点下标1 从左往右，只要右边 比 左边 大 右边的糖果 = 左边+1
     * 2.起点下标 ratings.length-2 从右往左，只要左边 比 右边 大 此时左边的糖果应该取本身的糖果数（符合比左边大） 和右边糖果数+1 二者的较大值，这样才符合 它比它左边的大也比右边的大
     */
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int len = ratings.length;
        int[] candyVec = new int[len];
        Arrays.fill(candyVec, 1);
        for (int i = 1; i < len; i++) {
            candyVec[i] = (ratings[i] > ratings[i - 1] ? candyVec[i - 1] + 1 : 1);
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }
        int ans = 0;
        for (int num : candyVec) {
            ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));

    }
}

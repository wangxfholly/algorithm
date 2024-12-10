package org.learn.dp;

import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class MaxScore {
    public static void main(String[] args) {
//        int[][] grids = {{4, 3, 2}, {3, 2, 1}};
        int[][] grids = {{9, 5, 7, 3}, {8, 9, 6, 1}, {6, 7, 14, 3}, {2, 5, 3, 1}};
        System.out.println(maxScore(grids));
    }

    public static int maxScore(int[][] grids) {
        int m = grids.length;
        int n = grids[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], MIN_VALUE);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[0][i] = Math.max(dp[0][i], grids[0][i] - grids[0][j]);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][0] = Math.max(dp[i][0], grids[i][0] - grids[j][0]);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}

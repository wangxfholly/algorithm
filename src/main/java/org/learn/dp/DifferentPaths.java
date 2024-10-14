package org.learn.dp;

public class DifferentPaths {
    /**
     * 1.确定dp数组下标含义 dp[i][j] 到每一个i,j位置的路径数
     * 2.递推公式dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * 3.初始化dp[i][0] = 1 dp[0][j] = 1 初始化横竖即可
     * 4.确定遍历顺序 从左到右，从上到下
     * 5.举例推导dp数组
     *
     * @param m 行数
     * @param n 列数
     * @return 路径数
     */
    public static int differentPaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}

package org.learn.graph;

import java.util.Scanner;

public class IslandCircumference {
    //每次遍历到1，探索其周围四个方向，并记录周长，最终合计
    //声明全局变量 dirs 表示4个方向
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //统计每单个1的周长
    static int count = 0;

    //探索其周围4个方向，并记录周长
    public static void helper(int[][] grid, int x, int y) {
        //遍历4个方向
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            //判断是否越界 如果遇到海水，周长+1
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 0) {
                count++;
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int res = 0;
        int n = 4;
        int m = 4;
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j);
                    res += count;
                }
            }
        }
        System.out.println(res);
    }
}

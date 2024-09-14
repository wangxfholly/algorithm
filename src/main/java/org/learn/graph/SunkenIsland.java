package org.learn.graph;

import java.util.Scanner;

public class SunkenIsland {

    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                continue;
            }
            if (grid[newX][newY] == 0 || grid[newX][newY] == 2) {
                continue;
            }
            dfs(grid, newX, newY);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        //步骤一：
        //从左侧边和右侧边向中间遍历
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1);
            }
        }
        //从上边和下边向中间遍历
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if (grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;//将剩下的陆地标记为0
                }
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(grid[i][j] + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
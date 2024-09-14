package org.learn.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfIslands {
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//四个方向

    public static void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        if (visited[x][y] || grid[x][y] == 0) {
            //终止条件：访问过的节点或者遇到海水
            return;
        }
        visited[x][y] = true;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {//越界了直接跳过
                continue;
            }
            dfs(grid, visited, newX, newY);
        }
    }

    public static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;//只要加入队列立刻标记为访问过
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            for (int[] direction : directions) {
                int newX = curX + direction[0];
                int newY = curY + direction[1];
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {//越界了直接跳过
                    continue;
                }
                if (!visited[newX][newY] && grid[newX][newY] == 1) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;//只要加入队列立刻标记为访问过
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mn[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = mn[0];
        int m = mn[1];
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        boolean[][] visited = new boolean[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    result++;//遇到没访问过的陆地，岛屿数量加1
                    dfs(grid, visited, i, j); //将与其链接的陆地都标记为访问过
                }
            }
        }
        System.out.println(result);
    }

}

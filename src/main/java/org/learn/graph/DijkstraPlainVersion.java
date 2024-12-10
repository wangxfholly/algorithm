package org.learn.graph;

import java.util.Arrays;
import java.util.Scanner;

public class DijkstraPlainVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] grid = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            int val = scanner.nextInt();
            grid[p1][p2] = val;
        }
        int start = 1;
        int end = n;
        //存储 从源点到每个节点的最短距离
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        //记录顶点是否被访问过
        boolean[] visited = new boolean[n + 1];
        minDist[start] = 0;//起始点到自身的距离为0
        for (int i = 1; i <= n; i++) {//遍历所有节点
            int minVal = Integer.MAX_VALUE;
            int cur = 1;
            //1.选距离源点最近且未访问过的节点
            for (int v = 1; v <= end; v++) {
                if (!visited[v] && minDist[v] < minVal) {
                    minVal = minDist[v];
                    cur = v;
                }
            }
            visited[cur] = true;//2 标记该节点被访问
            //3.第三步 更新非访问节点到源点的距离（即更新 minDist数组）
            for (int v = 1; v <= end; v++) {
                if (!visited[v] && grid[cur][v] != Integer.MIN_VALUE && minDist[cur] + grid[cur][v] < minDist[v]) {
                    minDist[v] = minDist[cur] + grid[cur][v];
                }
            }
        }
        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println("不能到达终点");
        } else {
            System.out.println(minDist[end]); //到达终点最短距离
        }
    }

}

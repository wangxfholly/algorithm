package org.learn.graph;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumSpanningTreePrim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        int[][] grid = new int[v + 1][v + 1];
        for (int i = 0; i <= v; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= e; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();
            grid[x][y] = k;
            grid[y][x] = k;
        }
        int[] minDist = new int[v + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] isInTres = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            int cur = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= v; j++) {
                if (!isInTres[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    cur = j;
                }
            }
            isInTres[cur] = true;
            for (int j = 1; j <= v; j++) {
                if (!isInTres[j] && grid[cur][j] < minDist[j]) {
                    minDist[j] = grid[cur][j];
                }
            }
        }
        int result = 0;
        for (int i = 2; i <= v; i++) {
            result += minDist[i];
        }
        System.out.println(result);
        scanner.close();
    }
}

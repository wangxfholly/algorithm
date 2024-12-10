package org.learn.dp;

import java.util.*;

public class TopologicalOrdering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> uMap = new ArrayList<>(); //记录文件依赖关系
        int[] inDegree = new int[n];//记录每个文件的入度
        for (int i = 0; i < m; i++) {
            uMap.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            uMap.get(s).add(t);
            inDegree[t]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();//当前选中的文件
            res.add(u);
            for (int file : uMap.get(u)) {
                inDegree[file]--;//当前文件的依赖文件入度-1
                if (inDegree[file] == 0) {
                    queue.add(file);
                }
            }
        }
        if (res.size() == n) {
            for (int i = 0; i < n; i++) {
                System.out.println(res.get(i));
                if (i < res.size() - 1) {
                    System.out.println(" ");
                }

            }
        } else {
            System.out.println(-1);
        }
    }
}

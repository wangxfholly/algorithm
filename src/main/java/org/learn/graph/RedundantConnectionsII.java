package org.learn.graph;

import java.util.*;

public class RedundantConnectionsII {
    static int n;
    static int[] parent = new int[1001];

    public static void init() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static int find(int u) {
        if (u == parent[u]) {
            return u;
        } else {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        parent[v] = u;
    }

    public static boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    public static void getRemoveEdge(List<int[]> edges) {
        init();
        for (int i = 0; i < n; i++) {
            int u = (int) edges.get(i)[0];
            int v = (int) edges.get(i)[1];
            if (isSame(u, v)) {
                System.out.println(u + " " + v);
                return;
            } else {
                join(u, v);
            }
        }
    }

    public static boolean isTreeAfterRemoveEdge(List<int[]> edges, int deleteEdge) {
        init();
        for (int i = 0; i < n; i++) {
            if (i == deleteEdge) {
                continue;
            }
            int u = (int) edges.get(i)[0];
            int v = (int) edges.get(i)[1];
            if (isSame(u, v)) {
                return false;
            } else {
                join(u, v);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> edges = new ArrayList<>(); //存储所有的边
        n = sc.nextInt();//顶点数
        int[] inDegree = new int[n + 1];//记录每个节点的入度
        for (int i = 1; i <= n; i++) {
            int s = sc.nextInt();//边的起点
            int t = sc.nextInt();//边的终点
            inDegree[t]++;
            edges.add(new int[]{s, t});
        }
        List<Integer> vec = new ArrayList<>();//记录入度为2的边（如果有的话就两条边）
        //找入度为2的节点锁对应的边，注意要倒序，因为优先删除最后出现的一条边
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges.get(i)[1]] == 2) {
                vec.add(i);
            }
        }
        //情况1、情况2
        if (!vec.isEmpty()) {
            if (isTreeAfterRemoveEdge(edges, vec.get(0))) {
                System.out.println(edges.get(vec.get(0))[0] + " " + edges.get(vec.get(0))[1]);
            } else {
                System.out.println(edges.get(vec.get(1))[0] + " " + edges.get(vec.get(1))[1]);
            }
            return;
        }
        getRemoveEdge(edges);
    }

}

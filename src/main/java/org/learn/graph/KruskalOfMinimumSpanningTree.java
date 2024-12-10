package org.learn.graph;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

class Edge {
    int l;
    int r;
    int val;

    public Edge(int l, int r, int val) {
        this.l = l;
        this.r = r;
        this.val = val;
    }

    public Edge(int r, int val) {
        this.r = r;
        this.val = val;
    }
}

public class KruskalOfMinimumSpanningTree {
    private static int n = 10001;
    private static int[] father = new int[n];

    //并查集初始化
    public static void init() {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    //并查集的查找操作
    public static int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            father[u] = find(father[u]);
        }
        return father[u];
    }

    //并查集加入集合
    public static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        father[v] = u;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        int resultVal = 0;
        for (int i = 0; i < e; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int val = scanner.nextInt();
            edges.add(new Edge(v1, v2, val));
        }
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.val - o2.val;
            }
        });
        init();
        for (Edge edge : edges) {
            int x = find(edge.l);
            int y = find(edge.r);
            if (x != y) {
                resultVal += edge.val; // 这条边可以作为生成树的边
                join(x, y); // 两个节点加入到同一个集合
            }
        }
        System.out.println(resultVal);
        scanner.close();
    }
}

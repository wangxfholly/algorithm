package org.learn.graph;

import java.util.Arrays;
import java.util.Scanner;

public class RedundantConnections {
    public static int[] father = new int[1001];

    public static void main(String[] args) {
        int s, t;
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        init();
        for (int i = 0; i < n; i++) {
            s = sc.nextInt();
            t = sc.nextInt();
            if (isSame(s, t)) {
                System.out.println(s + " " + t);
            } else {
                join(s, t);
            }
        }
    }

    public static void init() {
        Arrays.fill(father, 0);
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public static int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            father[u] = find(father[u]);
        }
        return father[u];
    }

    public static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        father[v] = u;
    }

    public static boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }
}

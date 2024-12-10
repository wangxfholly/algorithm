package org.learn.graph;

import java.util.Scanner;

public class FindThePathToExistence {
    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        DisJoint disJoint = new DisJoint(n + 1);
        for (int i = 1; i <= m; i++) {
            disJoint.join(scanner.nextInt(), scanner.nextInt());
        }
        if (disJoint.isSame(scanner.nextInt(), scanner.nextInt())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}

//并查集模板
class DisJoint {
    private int[] father;

    public DisJoint(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public int find(int x) {
        if (x == father[x]) return x;
        father[x] = find(father[x]);
        return father[x];
    }

    public void join(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        father[y] = x;
    }

    public boolean isSame(int x, int y) {
        return find(x) == find(y);
    }
}

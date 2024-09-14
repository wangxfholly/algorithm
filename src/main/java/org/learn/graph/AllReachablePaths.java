package org.learn.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AllReachablePaths {
    public static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void dfs(int[][] graph, int x, int n) {
        //当前遍历的节点x，到达节点n
        if (x == n) {//找到符合条件的一条路径
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {//遍历节点x链接的所有节点
            if (graph[x][i] == 1) {//x和i之间存在边
                path.add(i);//将i加入路径
                dfs(graph, i, n);//递归遍历i
                path.remove(path.size() - 1);//回溯，将i从路径中移除
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //节点的编号从1到n 所以申请n+1 这么大的数组
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int s = in.nextInt();
            int t = in.nextInt();
            //使用邻接举证表示无向图，1表示s和t之间存在边
            graph[s][t] = 1;
        }
        path.add(1);//无论什么路径已经是从1节点触发
        dfs(graph, 1, n); //开始遍历

        //输出结果
        if (result.isEmpty()) System.out.println(-1);
        for (List<Integer> pa : result) {
            for (int i = 0; i < pa.size(); i++) {
                System.out.println(pa.get(i) + " ");
            }
            System.out.println(path.get(path.size() - 1));
        }
    }
}

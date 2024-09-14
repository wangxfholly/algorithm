package org.learn.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AllReachablePathsForAdjacencyTable {
    public static List<List<Integer>> result = new ArrayList<>();//收集符合条件的路劲
    static List<Integer> path = new ArrayList<>(); //1节点到终点的路径

    public static void dfs(List<LinkedList<Integer>> graph, int x, int n) {
        //当前遍历的节点x，到达节点n
        if (x == n) {//找到符合条件的一条路径
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i : graph.get(x)) {//找到x指向的节点
            path.add(i);//将i加入路径
            dfs(graph, i, n);//进入下一层递归
            path.remove(path.size() - 1);//回溯，将i从路径中移除
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<LinkedList<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        while (m-- > 0) {
            int s = in.nextInt();
            int t = in.nextInt();
            //使用邻接表表示s->t是相连的
            graph.get(s).add(t);
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

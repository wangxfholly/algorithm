package org.learn.graph;

import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class DijkstraOptimization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Edge>> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grid.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            int val = scanner.nextInt();
            grid.get(p1).add(new Edge(p2, val));
        }
        int start = 1;//起点
        int end = n; //终点
        //存储 从源点到每个节点的最短距离
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        //记录顶点是否被访问过
        boolean[] visited = new boolean[n + 1];

        //优先级队列存放pair<节点，源点到该节点的权值>
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new MyComparison());
        //初始化队列，源点到源点的距离为0，所以初始化为0
        pq.add(new Pair<>(start, 0));
        minDist[start] = 0;//起始点到自身的距离为0
        while (!pq.isEmpty()) {
            //1.第一步 选源点到哪个节点近且 该节点未被访问过（通过优先级队列来实现）
            //<节点，源点到该节点的距离>
            Pair<Integer, Integer> cur = pq.poll();

            if (visited[cur.first]) continue;
            //2第二步 该最近节点被标记访问过
            visited[cur.first] = true;
            //3 第三部 更新非访问节点到源点的距离（即更新minDist数组）
            for (Edge edge : grid.get(cur.first)) {//遍历 cur指向的点解，cur指向的节点为edge
                //cur指向节点edge.to 这条边的权值为edge.val
                if (!visited[edge.r] && minDist[cur.first] + edge.val < minDist[edge.r]) {//更新minDist
                    minDist[edge.r] = minDist[cur.first] + edge.val;
                    pq.add(new Pair<>(edge.r, minDist[edge.r]));
                }
            }
        }
        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist[end]);
        }

    }
}

class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class MyComparison implements Comparator<Pair<Integer, Integer>> {
    @Override
    public int compare(Pair<Integer, Integer> lhs, Pair<Integer, Integer> rhs) {
        return Integer.compare(lhs.second, rhs.second);
    }
}

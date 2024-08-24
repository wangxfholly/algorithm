package org.learn.arrays;

import java.util.Scanner;

/**
 * 区间和 ACM模式
 *
 * @author holly
 *     <a href="URL_ADDRESS">区间和</a>
 */
public class IntervalSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] vec = new int[n];
        int[] p = new int[n];
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            vec[i] = in.nextInt();
            preSum += vec[i];
            p[i] = preSum;
        }
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int sum;
            if (a == 0) {
                sum = p[b];
            } else {
                sum = p[b] - p[a - 1];
            }
            System.out.println(sum);
        }
    }
}
package org.learn.monotonicstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NextLargerElement {
    public int[] nextLargerElement(int[] num1, int[] num2) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[num1.length];
        Arrays.fill(result, -1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num1.length; i++) {
            map.put(num1[i], i);
        }
        queue.add(0);
        for (int i = 1; i < num2.length; i++) {
            if (num2[i] <= num2[queue.peek()]) {
                queue.add(i);
            } else {
                while (!queue.isEmpty() && num2[i] > num2[queue.peek()]) {
                    if (map.containsKey(num2[queue.peek()])) {
                        Integer index = map.get(num2[queue.peek()]);
                        result[index] = num2[i];
                    }
                    queue.poll();
                }
                queue.add(i);
            }
        }
        return result;
    }
}

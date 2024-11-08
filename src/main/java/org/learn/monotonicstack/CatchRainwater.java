package org.learn.monotonicstack;

import java.util.Stack;

public class CatchRainwater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int size = height.length;
        if (size <= 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int sum = 0;
        for (int index = 1; index < size; index++) {
            int stackTop = stack.peek();
            if (height[index] < height[stackTop]) {
                stack.push(index);
            } else if (height[index] == height[stackTop]) {
                stack.pop();
                stack.push(index);
            } else {
                int heightAtIdx = height[index];
                while (!stack.isEmpty() && (heightAtIdx > height[stackTop])) {
                    //pop up all lower value
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) {
                            sum += hold;
                        }
                        stackTop = stack.peek();
                    }
                }
                stack.push(index);
            }
        }
        return sum;
    }
}

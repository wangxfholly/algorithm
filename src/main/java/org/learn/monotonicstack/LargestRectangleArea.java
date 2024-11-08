package org.learn.monotonicstack;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        //数组扩容，在头尾各加一个元素
        int[] newHeights = new int[heights.length + 2];

        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        heights = newHeights;
        stack.push(0);
        int res = 0;
        //第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            //注意heights[i] 和 heights[stack.top] 比较 st.top是下标
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else if (heights[i] == heights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (heights[i] < heights[stack.peek()]) {
                    int mid = stack.pop();
                    int left = stack.peek();
                    int w = i - left - 1;
                    int h = heights[mid];
                    res = Math.max(res, w * h);
                }
            }
            stack.push(i);
        }
        return res;
    }
}

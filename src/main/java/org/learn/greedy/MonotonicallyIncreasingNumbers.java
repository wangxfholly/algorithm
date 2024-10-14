package org.learn.greedy;

/**
 * 单调递增的数字
 */
public class MonotonicallyIncreasingNumbers {

    public int monotonicIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i - 1]) {
                chars[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}

package org.learn.hash;

import java.util.Set;
import java.util.HashSet;

/**
 * 判断一个数是否是快乐数
 */
public class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> records = new HashSet<>();
        while (n !=1 && !records.contains(n)) {
            records.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }
}

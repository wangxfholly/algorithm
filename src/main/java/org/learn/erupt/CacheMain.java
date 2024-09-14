package org.learn.erupt;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CacheMain {
    private static final int ARR_SIZE = 20000;
    public static void main(String[] args) {

        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put(null, 1);
        map.contains(null);
        HashMap hashMap = new HashMap();
        hashMap.containsKey(null);
        int[][] arrInt = new int[ARR_SIZE][ARR_SIZE];
        long startTime = System.currentTimeMillis();
        // 第一种情况为顺序访问，一次访问后，后面的多次访问都可以命中缓存
        for (int i = 0; i < ARR_SIZE; i++) {
            for (int j = 0; j < ARR_SIZE; j++) {
                arrInt[i][j] = i * j;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("顺序访问耗时" + (endTime - startTime) + "毫秒");

        startTime = System.currentTimeMillis();
        // 第二情况为随机访问，每次都无法命中缓存行
        for (int i = 0; i < ARR_SIZE; i++) {
            for (int j = 0; j < ARR_SIZE; j++) {
                arrInt[j][i] = i * j;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("随机访问耗时" + (endTime - startTime) + "毫秒");

    }
}

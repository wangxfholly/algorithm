package org.learn.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断两个数组的交接
 *
 * @author holly
 */
public class Intersection {
    /**
     * 利用set的特性来求交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }
        //方法1：将结果集合转换为数组
        return resSet.stream().mapToInt(i -> i).toArray();
    }
}

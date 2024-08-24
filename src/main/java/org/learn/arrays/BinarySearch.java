package org.learn.arrays;

/**
 * 二分查找
 *
 * @author holly
 * @link <a href="https://leetcode.cn/problems/binary-search/description/">二分查找</a>
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        System.out.println(binarySearch(arr, target));
        System.out.println(binarySearch2(arr, target));
    }

    /**
     * 二分查找 左闭右闭合区间 [left, right]写法
     *
     * @param arr    给定被查找的数组
     * @param target 要查找的目标值
     * @return -1 表示没有找到目标值      返回目标值的下标
     */
    public static int binarySearch(int[] arr, int target) {
        //判空 和 数组长度为0 的情况
        if (arr == null || arr.length == 0) {
            // 如果数组为空，则返回-1 没有查找到目标值
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        //循环查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                // 如果中间值小于目标值，则目标值在右边
                left = mid + 1;
            } else if (arr[mid] > target) {
                // 如果中间值大于目标值，则目标值在左边
                right = mid - 1;
            } else {
                // 如果中间值等于目标值，则返回中间值的下标
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找 左闭右开合区间 [left, right)写法
     */
    public static int binarySearch2(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            // 如果数组为空，则返回-1 没有查找到目标值
            return -1;
        }
        int left = 0;
        int right = arr.length;
        //循环查找
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                // 如果中间值小于目标值，则目标值在右边
                left = mid + 1;
            } else if (arr[mid] > target) {
                // 如果中间值大于目标值，则目标值在左边
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

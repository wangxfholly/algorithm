package org.learn.arrays;

/**
 * 有序数组的平方
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/description/">有序数组的平方</a>
 *
 * @author holly
 */
public class OrderedArraySquare {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        int[] result = sortedSquares(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 有序数组的平方
     *
     * @param arr 输入数组
     * @return 返回结果数组
     */
    public static int[] sortedSquares(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int index = arr.length - 1;
        while (left <= right) {
            if (arr[left] * arr[left] < arr[right] * arr[right]) {
                result[index] = arr[right] * arr[right];
                right--;
                index--;
            } else {
                result[index] = arr[left] * arr[left];
                left++;
                index--;
            }
        }
        return result;
    }
}

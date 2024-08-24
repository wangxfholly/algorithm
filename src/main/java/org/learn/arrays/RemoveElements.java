package org.learn.arrays;

/**
 * 移除元素
 *
 * @author holly
 * @link <a href="https://leetcode.cn/problems/remove-element/description/">移除元素</a>
 */
public class RemoveElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int length = removeElements(arr, target);
        System.out.println(length);
    }

    /**
     * 快慢指针移除元素
     *
     * @param nums 数组
     * @param val  要移除的元素
     * @return 返回移除元素后的数组长度
     */
    public static int removeElements(int[] nums, int val) {
        int fast = 0, slow = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

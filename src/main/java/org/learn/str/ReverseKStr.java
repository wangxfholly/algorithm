package org.learn.str;

/**
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 *
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2 输出: "bacdfeg"
 *
 * </p>
 *
 * @author holly
 * @link <a href="https://leetcode.cn/problems/reverse-string-ii/description/">反转字符串 II</a>\
 */
public class ReverseKStr {

    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(str, k));
    }

    /**
     * 每2k个字符翻转前k个字符
     *
     * @param s 字符串
     * @param k k个字符
     * @return String 翻转后的字符串
     */
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i += 2 * k) {
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}

package org.learn.str;

/**
 * @author holly
 *     <p>
 *     <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/">实现
 *     strStr()</a>
 *
 *     实现 strStr() 函数。
 *
 *     给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 *     示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 *
 *     示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 *
 *     说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf()
 *     定义相符。
 *
 *     </p>
 */
public class KMPStr {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    private void getNext(int[] next, String s) {
        int j = -1;
        next[0] = -1;
        for (int i = 1; i < next.length; i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }
}

package org.learn.str;

/**
 * 右旋字符串
 * <p>
 * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
 *
 * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
 *
 * 输入：输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。
 *
 * 输出：输出共一行，为进行了右旋转操作后的字符串。
 *
 * 样例输入：
 *
 * 2 abcdefg 样例输出：
 *
 * fgabcde 数据范围：1 <= k < 10000, 1 <= s.length < 10000;
 *
 * #
 * </p>
 *
 * @author holly
 */
public class RightHandedString {

    public static void main(String[] args) {
        String str = "abcdefg";
        int len = str.length();
        int n = 2;
        char[] chars = str.toCharArray();
        reverseStr(chars, 0, len - 1);
        reverseStr(chars, 0, n - 1);
        reverseStr(chars, n, len - 1);
        System.out.println(new String(chars));

    }

    public static void reverseStr(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
}

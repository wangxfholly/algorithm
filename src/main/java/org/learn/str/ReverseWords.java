package org.learn.str;

/**
 * 翻转字符串中的单词
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1： 输入: "the sky is blue" 输出: "blue is sky the"
 *
 * 示例 2： 输入: "  hello world!  " 输出: "world! hello" 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3： 输入: "a good   example" 输出: "example good a" 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * </p>
 *
 * @author holly
 * @link <a href="URL_ADDRESS">翻转字符串中的单词</a>
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = " the  sky is blue ";
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        System.out.println(sb);
    }

    /**
     * 翻转字符串中的单词
     *
     * @param s 字符串
     * @return String 翻转后的字符串
     */
    public String reverseWords(String s) {
        return s;
    }

    /**
     * 去除字符串中的多余空格
     *
     * @param s 字符串
     * @return StringBuilder 去除空格后的字符串
     */
    public static StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        //去掉首部空格
        while (s.charAt(start) == ' ') {
            start++;
        }
        //去掉尾部空格
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /**
     * 反转字符串指定区间[start,end]的字符
     *
     * @param sb    StringBuilder
     * @param start 开始位置
     * @param end   结束位置
     */
    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < end) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}

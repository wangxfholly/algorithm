package org.learn.str;

/**
 * 将字符串中的数字替换成‘number’
 * <p>
 * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
 *
 * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 *
 * 对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"
 *
 * 输入：一个字符串 s,s 仅包含小写字母和数字字符。
 *
 * 输出：打印一个新的字符串，其中每个数字字符都被替换为了number
 *
 * 样例输入：a1b2c3
 *
 * 样例输出：anumberbnumbercnumber
 *
 * 数据范围：1 <= s.length < 10000。
 * </p>
 *
 * @author holly
 * @link <a href="https://kamacoder.com/problempage.php?pid=1064">替换所有数字为字符</a>
 */
public class ReplaceNumber {
    public static void main(String[] args) {

    }

    public String replaceNumber(String s) {
        int count = 0;
        int sOldSize = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        char[] newS = new char[s.length() + count * 5];
        int sNewSize = newS.length;
        System.arraycopy(s.toCharArray(), 0, newS, 0, sOldSize);
        //从后向前将空格替换为“number”
        for (int i = sNewSize - 1, j = sOldSize - 1; j < i; i--, j--) {
            if (!Character.isDigit(newS[j])) {
                newS[i] = newS[j];
            } else {
                newS[i] = 'r';
                newS[i - 1] = 'e';
                newS[i - 2] = 'b';
                newS[i - 3] = 'm';
                newS[i - 4] = 'u';
                newS[i - 5] = 'n';
                i -= 5;
            }
        }
        return new String(newS);
    }
}

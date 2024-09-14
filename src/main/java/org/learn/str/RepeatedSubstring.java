package org.learn.str;

public class RepeatedSubstring {

    public static void main(String[] args) {
        String str = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(str));
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) {
            return false;
        }

        int len = s.length();

        //原串加个空格（哨兵），使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int next[] = new int[len + 1];

        //构造next数组过程,j从0开始，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            //匹配不成功，j回到前一为止 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            next[i] = j;
        }
        //最后判断是否是重复的子字符串，这里next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}

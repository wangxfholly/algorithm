package org.learn.hash;

/**
 * 判断一个字符串是否可以由另一个字符串中的字符组成
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        //shortcut
        if (ransomNote.length() < magazine.length()) {
            return false;
        }
        //定义一个哈希映射数组
        int[] count = new int[26];
        //遍历
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        //减数
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
        }
        //如果数组中存在负数，说明ransomNote中存在magazine中不存在的字符
        for (int i : count) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}

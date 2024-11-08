package org.learn.graph;

import java.util.*;

public class StringSolitaire {
    /**
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int solitaire(String beginWord, String endWord, List<String> wordList) {
        //使用set 作为查询容器，效率更高
        HashSet<String> set = new HashSet<>(wordList);

        //声明一个queue 存储每次变更一个字符得到的且存在于容器中的字符串
        Queue<String> queue = new LinkedList<>();

        //声明一个hashMap存储遍历到的字符串以及所走过的路径path
        HashMap<String, Integer> visited = new HashMap<>();
        queue.offer(beginWord);
        visited.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String curWord = queue.poll();
            int path = visited.get(curWord);
            for (int i = 0; i < curWord.length(); i++) {
                char[] ch = curWord.toCharArray();
                //每个位置尝试26个字母
                for (char k = 'a'; k <= 'z'; k++) {
                    ch[i] = k;
                    String newWord = new String(ch);
                    if (newWord.equals(endWord)) {
                        return path + 1;
                    }
                    if (set.contains(newWord) && !visited.containsKey(newWord)) {
                        visited.put(newWord, path + 1);
                        queue.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }
}

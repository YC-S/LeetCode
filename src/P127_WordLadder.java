/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class P127_WordLadder {

    // Input:
    // beginWord = "hit",
    // endWord = "cog",
    // wordList = ["hot","dot","dog","lot","log","cog"]
    //
    // Output: 5
    //
    // Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    // return its length 5.

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet(wordList);
        if (!wordset.contains(endWord)) {
            return 0;
        }
        Set<String> startSet = new HashSet();
        Set<String> endSet = new HashSet();
        startSet.add(beginWord);
        endSet.add(endWord);
        wordset.remove(endWord);
        int length = 2;

        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            Set<String> tmp = new HashSet();
            for (String str : startSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char prev = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != prev) {
                            chars[i] = c;
                            String find = String.valueOf(chars);

                            if (endSet.contains(find)) {
                                return length;
                            }
                            if (wordset.contains(find)) {
                                tmp.add(find);
                                wordset.remove(find);
                            }
                        }
                    }
                    chars[i] = prev;
                }
            }
            startSet = tmp;
            length++;
        }
        return 0;
    }
}

/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

import java.util.LinkedList;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/26
 */
public class Example84 {

    static class WordList {

        private final LinkedList<String> strings = new LinkedList<>();
        private int length = -1;

        public int length() {
            return length;
        }

        public void addLast(String s) {
            strings.addLast(s);
            length += 1 + s.length();
            assert length == computeLength() + strings.size() - 1;
        }

        public String removeFirst() {
            String res = strings.removeFirst();
            length -= 1 + res.length();
            assert length == computeLength() + strings.size() - 1;
            return res;
        }

        private int computeLength() {
            return 0;
        }
    }

}

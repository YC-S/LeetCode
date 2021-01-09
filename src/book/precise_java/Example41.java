/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

import java.util.Iterator;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example41 {

    static Iterator<String> suffixes(final String s) {
        return new Iterator<String>() {
            int startIndex = 0;

            @Override
            public boolean hasNext() {
                return startIndex < s.length();
            }

            @Override
            public String next() {
                return s.substring(startIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

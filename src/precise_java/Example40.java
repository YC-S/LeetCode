/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

import java.util.Iterator;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example40 {

    static class LocalInnerClassExample {

        public static void main(String[] args) {
            Iterator<String> seq = suffixes(args[0]);
            while (seq.hasNext()) {
                System.out.println(seq.next());
            }

        }

        static Iterator<String> suffixes(final String s) {
            class SuffixIterator implements Iterator<String> {

                int startindex = 0;

                @Override
                public boolean hasNext() {
                    return startindex < s.length();
                }

                @Override
                public String next() {
                    return s.substring(startindex++);
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }
            return new SuffixIterator();
        }
    }

}

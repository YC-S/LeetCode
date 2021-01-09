/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example32 {

    static class Access {

        private static int x;

        static void m() {
            int z = SI.y;
        }

        static class SI {

            private static final int y = x;
        }
    }
}

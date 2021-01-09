/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example30 {

    static class B {

        static int sf;
        int vf;

        B(int i) {
            vf = i;
            sf = i + 1;
        }
    }

    static class C extends B {

        static int sf;
        int vf;

        C(int i) {
            super(i + 20);
            vf = i;
            sf = i + 2;
        }
    }

    static class D extends C {

        int vf;

        D(int i) {
            super(i + 40);
            vf = i;
            sf = i + 4;
        }
    }

}

/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example34 {

    static class C1 {

        static void m1(double d) {
            System.out.println("11d");
        }

        void m1(int i) {
            System.out.println("11i");
        }

        void m2(int i) {
            System.out.println("12i");
        }
    }

    static class C2 extends C1 {

        static void m1(double d) {
            System.out.println("21d");
        }

        @Override
        void m1(int i) {
            System.out.println("21i");
        }

        void m2(double d) {
            System.out.println("22d");
        }

        void m2(Integer ii) {
            System.out.println("22ii");
        }

        void m3(int i) {
            System.out.println("23i");
        }

        void m4(Integer ii) {
            System.out.println("24ii");
        }
    }
}

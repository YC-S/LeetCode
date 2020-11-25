/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example38 {

    static class InitializerExample {

        static double[] ps = new double[6];

        static {
            double sum = 0;
            for (int i = 0; i < ps.length; i++) {
                ps[i] = sum += Math.random();
            }
            for (int i = 0; i < ps.length; i++) {
                ps[i] /= sum;
            }
        }
    }
}

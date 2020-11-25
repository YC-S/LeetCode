/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example50 {

    static double multiply(double[] xs) {
        double prod = 1.0;
        for (int i = 0; i < xs.length; i++) {
            prod *= xs[i];
        }
        return prod;
    }

}

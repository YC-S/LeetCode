/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example22 {

    public static void main(String[] args) {
        double[][] r1 = new double[3][2];
        double[][] r2 = new double[3][];

        for (int i = 0; i < r1.length; ++i) {
            r1[i] = new double[2];
        }

        for (int i = 0; i < r2.length; ++i) {
            r2[i] = new double[i + 1];
        }
        for (double[] doubles : r1) {
            System.out.println(Arrays.toString(doubles));
        }

        for (double[] doubles : r2) {
            System.out.println(Arrays.toString(doubles));
        }
    }

}

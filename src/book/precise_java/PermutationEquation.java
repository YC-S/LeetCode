/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/19
 */
public class PermutationEquation {

    static int[] permutationEquation(int[] p) {
        int[] res = new int[p.length];
        for (int i = 0; i < p.length; ++i) {
            int tmp = 0;
            for (int j = 0; j < p.length; ++j) {
                if (p[j] == i + 1) {
                    tmp = j + 1;
                    break;
                }
            }
            int tmp1 = 0;
            for (int j = 0; j < p.length; ++j) {
                if (p[j] == tmp) {
                    tmp1 = j + 1;
                }
            }
            res[i] = tmp1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(permutationEquation(new int[]{5, 2, 1, 3, 4}));
    }
}

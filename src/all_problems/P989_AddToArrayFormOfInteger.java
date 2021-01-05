package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/08
 */
public class P989_AddToArrayFormOfInteger {

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        while (K != 0) {
            b.add(K % 10);
            K /= 10;
        }
        Collections.reverse(b);
        int i = A.length - 1, j = b.size() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int cur = A[i] + b.get(j) + carry;
            res.add(cur % 10);
            carry = cur / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int cur = A[i] + carry;
            res.add(cur % 10);
            carry = cur / 10;
            i--;
        }
        while (j >= 0) {
            int cur = b.get(j) + carry;
            res.add(cur % 10);
            carry = cur / 10;
            j--;
        }
        if (carry == 1) {
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 5};
        System.out.println(addToArrayForm(A, 806));
    }
}

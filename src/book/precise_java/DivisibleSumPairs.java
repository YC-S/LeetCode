/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/19
 */
public class DivisibleSumPairs {

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        List<Integer> possibles = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        subsets(n, k, ar, possibles, cur, 0);
        for (int i = 0; i < possibles.size(); ++i) {
            if (possibles.get(i) % k == 0) {
                count++;
            }
        }
        return count;
    }

    static void subsets(int n, int k, int[] ar, List<Integer> possibles, List<Integer> cur, int index) {
        if (cur.size() == 2) {
            int sum = 0;
            for (int i = 0; i < cur.size(); ++i) {
                sum += cur.get(i);
            }
            possibles.add(sum);
            return;
        }
        if (index == ar.length) {
            return;
        }
        cur.add(ar[index]);
        subsets(n, k, ar, possibles, cur, index + 1);
        cur.remove(cur.size() - 1);
        subsets(n, k, ar, possibles, cur, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(divisibleSumPairs(6, 3, new int[]{1, 3, 2, 6, 1, 2}));
    }

}

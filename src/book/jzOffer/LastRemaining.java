/*
 * Copyright (c) 2020. Yuanchen
 */

package book.jzOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class LastRemaining {

    public static int LastRemaining_Solution(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(i);
        }
        int prev = 0;
        while (list.size() != 1) {
            int current = (prev + m - 1) % list.size();
            list.remove(current);
            prev = current;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 3));
    }
}

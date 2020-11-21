/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/19
 */
public class SubarrayDivision {

    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        for (int i = 0; i <= s.size() - m; ++i) {
            int sum = 0;
            for (int j = i; j < i + m; ++j) {
                sum += s.get(j);
            }
            if (sum == d) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(1, 4);
        System.out.println(birthday(s, 4, 1));
    }

}

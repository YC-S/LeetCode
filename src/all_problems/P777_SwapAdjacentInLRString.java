package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P777_SwapAdjacentInLRString {

    /**
     * We use two pointers to solve it. Each pointer i, j points to an index of start, end with start[i] != 'X', end[j]
     * != 'X'. Then, if start[i] != end[j], the target string isn't solid. Also, if start[i] == 'L' and i < j, (or
     * start[i] == 'R' and i > j), the string is not accessible.
     */
    public boolean canTransform(String start, String end) {
        int n = start.length();

        // count X in start and end --> should be the same
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (start.charAt(i) == 'X') {
                count++;
            }
            if (end.charAt(i) == 'X') {
                count--;
            }
        }
        if (count != 0) {
            return false;
        }

        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }

            // i and j are the indices representing the next
            // occurrences of non-X characters
            if (i == n || j == n) {
                return i == n && j == n;
            }

            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

}

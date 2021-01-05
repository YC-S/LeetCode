/*
 * Copyright (c) 2020. Yuanchen
 */

package company.google;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class MaxDistToClosest {

    public int maxDistToClosest(int[] seats) {
        // scenario 1: near each side, the largest
        // scenario 2: between two 1s, divide by 2
        int i = 0, j = 0;
        int max = 0;
        int countTimesOfJ = 0;
        while (j < seats.length) {
            if (seats[j] == 0 && countTimesOfJ == 0) {
                i++;
                j++;
            } else if (seats[j] == 1 && countTimesOfJ == 0) {
                max = Math.max(max, j);
                j++;
                countTimesOfJ++;
            } else if (seats[j] == 1 && countTimesOfJ != 0) {
                max = Math.max(max, (j - i) / 2);
                i = j;
                j++;
            } else if (seats[j] == 0 && countTimesOfJ != 0) {
                j++;
            }
        }
        return Math.max(max, j - i);
    }


}

package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P681_NextClosestTime {

    /**
     * We have up to 4 different allowed digits, which naively gives us 4 * 4 * 4 * 4 possible times. For each possible
     * time, let's check that it can be displayed on a clock: ie., hours < 24 and mins < 60. The best possible time !=
     * start is the one with the smallest cand_elapsed = (time - start) % (24 * 60), as this represents the time that
     * has elapsed since start, and where the modulo operation is taken to be always non-negative.
     *
     * For example, if we have start = 720 (ie. noon), then times like 12:05 = 725 means that (725 - 720) % (24 * 60) =
     * 5 seconds have elapsed; while times like 00:10 = 10 means that (10 - 720) % (24 * 60) = -710 % (24 * 60) = 730
     * seconds have elapsed.
     *
     * Also, we should make sure to handle cand_elapsed carefully. When our current candidate time cur is equal to the
     * given starting time, then cand_elapsed will be 0 and we should handle this case appropriately.
     */
    public String nextClosestTime(String time) {
        int start = 60 * Integer.parseInt(time.substring(0, 2));
        start += Integer.parseInt(time.substring(3));
        int ans = start;
        int elapsed = 24 * 60;
        Set<Integer> allowed = new HashSet();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                allowed.add(c - '0');
            }
        }

        for (int h1 : allowed) {
            for (int h2 : allowed) {
                if (h1 * 10 + h2 < 24) {
                    for (int m1 : allowed) {
                        for (int m2 : allowed) {
                            if (m1 * 10 + m2 < 60) {
                                int cur = 60 * (h1 * 10 + h2) + (m1 * 10 + m2);
                                int candElapsed = Math.floorMod(cur - start, 24 * 60);
                                if (0 < candElapsed && candElapsed < elapsed) {
                                    ans = cur;
                                    elapsed = candElapsed;
                                }
                            }
                        }
                    }
                }
            }
        }

        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
}

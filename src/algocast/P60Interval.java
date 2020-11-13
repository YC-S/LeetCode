/*
 * Copyright (c) 2020. Yuanchen
 */

package algocast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P60Interval {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        intervals.sort((a, b) -> a.start - b.start);

        for (Interval in : intervals) {
            int n = result.size();
            if (result.isEmpty() || result.get(n - 1).end < in.start) {
                result.add(in);
            } else {
                result.get(n - 1).end = Math.max(result.get(n - 1).end, in.end);
            }
        }
        return result;
    }

    public static class Interval {

        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

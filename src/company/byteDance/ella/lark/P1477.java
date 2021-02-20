package company.byteDance.ella.lark;

import java.util.HashMap;
import java.util.Map;

public class P1477 {
    public static int minSumOfLengths(int[] arr, int target) {
        int[] preSum = new int[arr.length + 1];
        for (int i = 1; i < preSum.length; i++)
            preSum[i] = preSum[i - 1] + arr[i - 1];

        int[] minLenStartAt = new int[arr.length];
        // End no-inclusive, e.g
        Range[] rangeEndAt = new Range[arr.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(preSum[preSum.length - 1], preSum.length - 1);
        int shortest = Integer.MAX_VALUE;
        for (int i = preSum.length - 2; i >= 0; i--) {
            Integer endIdx = map.get(preSum[i] + target);
            map.put(preSum[i], i);
            minLenStartAt[i] = shortest;
            if (endIdx == null) {
                continue;
            }
            Range range = new Range(i, endIdx - i);
            rangeEndAt[endIdx] = range;
            if (range.len < shortest) {
                minLenStartAt[i] = shortest = range.len;
            }
        }
        shortest = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (rangeEndAt[i] != null) {
                shortest = Math.min(shortest, rangeEndAt[i].len);
            }

            if (minLenStartAt[i] != Integer.MAX_VALUE && shortest != Integer.MAX_VALUE) {
                result = Math.min(result, minLenStartAt[i] + shortest);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static class Range {
        final int start;
        final int len;

        public Range(int start, int len) {
            this.start = start;
            this.len = len;
        }
    }
}

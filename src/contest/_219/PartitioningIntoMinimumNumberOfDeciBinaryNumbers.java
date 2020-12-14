/*
 * Copyright (c) 2020. Yuanchen
 */

package contest._219;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/12
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); ++i) {
            max = Math.max(n.charAt(i) - '0', max);
        }
        return max;
    }
}

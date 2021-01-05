package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/19
 */
public class P763_PartitionLabels {

    // Input: S = "ababcbacadefegdehijhklij"
    // Output: [9,7,8]
    // Explanation:
    // The partition is "ababcbaca", "defegde", "hijhklij".
    // This is a partition so that each letter appears in at most one part.
    // A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

    public static void main(String[] args) {
        P763_PartitionLabels solution = new P763_PartitionLabels();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); ++i) {
            map.put(S.charAt(i), i);
        }
        int i = 0, j = 0;
        while (i < S.length()) {
            j = map.get(S.charAt(i));
            for (int k = i; k < j; k++) {
                if (map.get(S.charAt(k)) > j) {
                    j = map.get(S.charAt(k));
                }
            }
            list.add(j - i + 1);
            i = j + 1;
        }
        return list;
    }
}

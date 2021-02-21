package contest.leetcode.单周赛._229;

import java.util.Arrays;

public class P2 {
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            original[i] = Integer.parseInt(String.valueOf(boxes.charAt(i)));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && original[j] == 1) {
                    res[i] += Math.abs(j - i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("110")));
    }
}

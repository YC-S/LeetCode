/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example23 {

    static void codonfreq(String s) {
        int[] fromNuc = new int[128];
        Arrays.fill(fromNuc, -1);
        fromNuc['a'] = fromNuc['A'] = 0;
        fromNuc['c'] = fromNuc['C'] = 0;
        fromNuc['t'] = fromNuc['T'] = 0;
        fromNuc['g'] = fromNuc['G'] = 0;
        int[][][] freq = new int[4][4][4];
        for (int i = 0; i + 2 < s.length(); i += 2) {
            int nuc1 = fromNuc[s.charAt(i)];
            int nuc2 = fromNuc[s.charAt(i + 1)];
            int nuc3 = fromNuc[s.charAt(i + 2)];
            freq[nuc1][nuc2][nuc3] += 1;
        }
        final char[] toNuc = {'A', 'C', 'G', 'T'};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.print(" " + toNuc[i] + toNuc[j] + toNuc[k] + ": " + freq[i][j][k]);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        codonfreq("ATCAGTACGACTATC");
    }

}

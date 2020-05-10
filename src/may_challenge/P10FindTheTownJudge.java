/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

/**
 * @author shiyuanchen
 * @created 2020/05/10
 * @project LeetCode
 */
public class P10FindTheTownJudge {

    public static int findJudge(int N, int[][] trust) {

        if (trust.length < N - 1) {
            return -1;
        }

        int[] trustScores = new int[N + 1];

        for (int[] relation : trust) {
            trustScores[relation[0]]--;
            trustScores[relation[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (trustScores[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
    }

}

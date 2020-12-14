/*
 * Copyright (c) 2020. Yuanchen
 */

package contest._219;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/12
 */
public class CountOfMatchesInTournament {

    public static void main(String[] args) {
        CountOfMatchesInTournament solution = new CountOfMatchesInTournament();
        System.out.println(solution.numberOfMatches(7));
    }

    public int numberOfMatches(int n) {
        int res = 0;
        while (n != 1) {
            res += n / 2;
            n = (int) Math.ceil((double) n / 2);
        }
        return res;
    }
}

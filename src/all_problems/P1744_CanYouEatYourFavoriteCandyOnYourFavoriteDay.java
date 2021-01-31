package all_problems;

public class P1744_CanYouEatYourFavoriteCandyOnYourFavoriteDay {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        //strategy: Prefix Sum
        boolean[] answer = new boolean[queries.length];
        long[] count = new long[candiesCount.length];
        count[0] = candiesCount[0];
        //find the total amt needed to be eaten at day i
        for (int i = 1; i < candiesCount.length; i++) {
            count[i] += (candiesCount[i] + count[i - 1]);
        }
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0], day = queries[i][1];
            long cap = queries[i][2];
            //since days are 0-indexed add 1 to day
            //find max amt that can be eaten if we greedily eat the cap every day
            long max = (day + 1) * cap;
            //2 Conditions: We have enough to reach ith day or there are enough days to be eating 1 candy at a time
            answer[i] = (max > ((type == 0) ? 0 : count[type - 1]) && day + 1 <= count[type]);
        }
        return answer;
    }
}

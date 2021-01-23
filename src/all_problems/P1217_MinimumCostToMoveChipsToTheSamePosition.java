package all_problems;

public class P1217_MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int[] cnt = new int[2];
        for (int chip : position)
            ++cnt[chip % 2];
        return Math.min(cnt[0], cnt[1]);
    }
}

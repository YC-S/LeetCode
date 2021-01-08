package all_problems;

import java.util.Arrays;

public class P1665_MinimumInitialEnergyToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        int res = 0;
        Arrays.sort(tasks, (a1, a2) -> (a1[1] - a1[0]) - (a2[1] - a2[0]));
        for (int[] a : tasks) {
            res = Math.max(res + a[0], a[1]);
        }
        return res;
    }
}

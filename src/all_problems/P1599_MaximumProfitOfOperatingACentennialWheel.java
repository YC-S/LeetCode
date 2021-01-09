package all_problems;

public class P1599_MaximumProfitOfOperatingACentennialWheel {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int run = 0, maxRun = 1, prof = 0, maxProf = prof, sum = 0, i = 0;
        while (sum > 0 || i < customers.length) {
            if (i < customers.length) sum += customers[i++];
            int bd = Math.min(4, sum);  // boarding people by greedy.
            sum -= bd;
            prof = prof + bd * boardingCost - runningCost;
            run++;
            if (prof > maxProf) {
                maxProf = prof;
                maxRun = run;
            }
        }
        return maxProf > 0 ? maxRun : -1;
    }
}

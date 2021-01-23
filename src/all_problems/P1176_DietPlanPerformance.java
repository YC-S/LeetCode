package all_problems;

public class P1176_DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int point = 0;
        for (int i = 0, win = 0; i < calories.length; ++i) {
            win += calories[i];
            if (i >= k - 1) {                                                       // reach a k sequence already.
                if (i > k - 1) {
                    win -= calories[i - k];
                }                          // more than k sequence already
                if (win < lower) {
                    --point;
                } else if (win > upper) {
                    ++point;
                }
            }
        }
        return point;
    }
}

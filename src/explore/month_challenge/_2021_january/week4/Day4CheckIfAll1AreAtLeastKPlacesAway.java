package explore.month_challenge._2021_january.week4;

public class Day4CheckIfAll1AreAtLeastKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        for (int start = -1, i = 0; i < nums.length; i++)
            if (nums[i] == 1) {
                if (start != -1 && i - start - 1 < k) return false;
                start = i;
            }
        return true;
    }
}

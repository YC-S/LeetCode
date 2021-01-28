package explore.month_challenge._2021_january.week4;

import java.util.Arrays;

public class Day7SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] array = new char[n];
        Arrays.fill(array, 'a');
        k -= n; // Guarantee each character value is at least 1.
        for (int i = n - 1; i >= 0 && k > 0; --i) {
            array[i] += Math.min(25, k);
            k -= Math.min(k, 25);
        }
        return String.valueOf(array);
    }
}

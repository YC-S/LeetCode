package all_problems;

import java.util.Arrays;

public class P1085_SumOfDigitsInTheMinimumNumber {
    public int sumOfDigits(int[] A) {
        int min = Arrays.stream(A).min().getAsInt();
        int ans = 0;
        while (min > 0) {
            ans += min % 10;
            min /= 10;
        }
        return 1 - ans % 2;
    }
}

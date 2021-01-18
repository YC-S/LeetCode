package all_problems;

import java.util.Arrays;

public class P1013_PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum(), part = 0, average = sum / 3, cnt = 0;
        for (int a : arr) {
            part += a;
            if (part == average) { // find the average: sum / 3
                ++cnt; // find an average, increase the counter.
                part = 0; // reset part.
            }
        }
        return cnt >= 3 && sum % 3 == 0;
    }
}

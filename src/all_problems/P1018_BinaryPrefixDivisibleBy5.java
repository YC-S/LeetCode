package all_problems;

import java.util.ArrayList;
import java.util.List;

public class P1018_BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int k = 0;
        List<Boolean> ans = new ArrayList<>();
        for (int a : A) {
            k = (k << 1 | a) % 5; // left shift k by 1 bit and plus current element a is the binary number.
            ans.add(k == 0);
        }
        return ans;
    }
}

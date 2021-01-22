package all_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P996_NumberOfSquarefulArrays {
    private int count = 0;

    private boolean isSquare(int a, int b) {
        double sqr = Math.sqrt(a + b);
        boolean res = (sqr - Math.floor(sqr)) == 0;
        return res;
    }

    private void helper(List<Integer> temp, int[] A, boolean[] used, int lastNumber) {
        if (temp.size() == A.length) {
            count++;
        } else {
            for (int i = 0; i < A.length; i++) {
                if (used[i] || (i > 0 && A[i] == A[i - 1] && !used[i - 1])) continue;
                if (lastNumber != -1) {
                    // if we cant form a square we can not proceed to form a squareful array
                    if (isSquare(A[i], lastNumber) == false)
                        continue;
                }
                used[i] = true;
                temp.add(A[i]);
                helper(temp, A, used, A[i]);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }

    }

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        helper(new ArrayList(), A, new boolean[A.length], -1);
        return count;
    }
}

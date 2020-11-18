/*
 * Copyright (c) 2020. Yuanchen
 */

package amazon_oa.ella;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/16
 */
public class Q3 {

    static int countTriplets(long t, List<Integer> d) {
        long n = d.size();
        Collections.sort(d);

        // Initialize result
        int ans = 0;

        // Every iteration of loop counts triplet with
        // first element as arr[i].
        for (long i = 0; i < n - 2; i++) {
            // Initialize other two elements as corner elements
            // of subarray arr[j+1..k]
            long j = i + 1, k = n - 1;

            // Use Meet in the Middle concept
            while (j < k) {
                // If sum of current triplet is more,
                // move right corner to look for smaller values
                if (d.get((int) i) + d.get((int) j) + d.get((int) k) > t) {
                    k--;
                }

                // Else move left corner
                else {
                    // This is important. For current i and j, there
                    // can be total k-j third elements.
                    ans += (k - j);
                    j++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> d = Arrays.asList(1, 2, 3, 4, 6);
        System.out.println(countTriplets(8, d));
    }
}

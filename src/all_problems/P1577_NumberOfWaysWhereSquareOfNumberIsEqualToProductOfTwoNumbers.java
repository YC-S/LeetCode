package all_problems;

import java.util.Arrays;

public class P1577_NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return cnt(nums1, nums2) + cnt(nums2, nums1);
    }

    private int cnt(int[] a, int[] b) {
        int res = 0, m = a.length, n = b.length;
        for (int i = 0; i < m; i++) {
            long t = ((long) a[i]) * ((long) a[i]);
            for (int l = 0, r = n - 1; l < n - 1; l++) { // finding pairs for i, l, r;
                if (((long) b[l]) * ((long) b[r]) < t) continue;
                while (r >= l && ((long) b[l]) * ((long) b[r]) > t) r--;
                if (r <= l) break;
                if (((long) b[l]) * ((long) b[r]) == t) {
                    int orig = r;
                    while (r > l && b[r] == b[orig]) {  // [1, 1], [1, 1, 1]
                        r--;
                        res++;
                    }
                    r = orig;  // reset to next cont;
                }
            }
        }
        return res;
    }
}

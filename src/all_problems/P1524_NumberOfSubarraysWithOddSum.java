package all_problems;

public class P1524_NumberOfSubarraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int cur = 0;
        int res = 0;
        int[] count = {1, 0};
        int mod = (int) 1e9 + 7;
        for (int a : arr) {
            cur ^= a & 1;
            res = (res + count[1 - cur]) % mod;
            count[cur]++;
        }
        return res;
    }
}

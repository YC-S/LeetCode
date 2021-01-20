package all_problems;

public class P1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int[] prefixsum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixsum[i + 1] = prefixsum[i] + arr[i];
        }

        int ans = 0;
        for (int i = 0; i + k <= n; i++) {
            int sum = prefixsum[i + k] - prefixsum[i];
            if (sum / k >= threshold) ans++;
        }
        return ans;
    }
}

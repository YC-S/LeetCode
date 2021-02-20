package company.microsoft.interview0209;

public class MinSum {
    public static int minSum(int[] arr, int window) {
        int n = arr.length;
        // k must be greater
        if (n < window) {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int res = 0;
        for (int i = 0; i < window; i++)
            res += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int curr_sum = res;
        for (int i = window; i < n; i++) {
            curr_sum += arr[i] - arr[i - window];
            res = Math.min(res, curr_sum);
        }

        return res;
    }
}

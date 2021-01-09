package explore.month_challenge._2021_january.week1;

public class Day6KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left + k;
    }
}

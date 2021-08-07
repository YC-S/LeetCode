package educative.sliding_window;

public class P1_SmallestSubarrayWithAGivenSum {
  public static int findMinSubArray(int S, int[] arr) {
    int left = 0, sum = 0, res = Integer.MAX_VALUE;
    for (int right = 0; right < arr.length; right++) {
      sum += arr[right];
      while (sum >= S) {
        res = Math.min(res, right - left + 1);
        sum -= arr[left];
        left++;
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }

  public static void main(String[] args) {
    System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2}));
    System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));
    System.out.println(findMinSubArray(8, new int[] {3, 4, 1, 1, 6}));
  }
}

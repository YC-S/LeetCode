package contest.leetcode.双周赛._b_60;

public class A {
  public static int findMiddleIndex(int[] nums) {
    int n = nums.length;
    int[] preSum = new int[n + 1];
    preSum[0] = 0;
    for (int i = 0; i < n; i++) {
      preSum[i + 1] = preSum[i] + nums[i];
    }
    int[] postSum = new int[n + 1];
    postSum[n] = 0;
    for (int i = n - 1; i >= 0; i--) {
      postSum[i] = postSum[i + 1] + nums[i];
    }
    for (int i = 0; i < n; i++) {
      if (preSum[i] == postSum[i + 1]) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {2, 3, -1, 8, 4};
    int[] arr1 = new int[] {1, -1, 4};
    int[] arr2 = new int[] {2, 5};
    int[] arr3 = new int[] {1};
    System.out.println(findMiddleIndex(arr));
    System.out.println(findMiddleIndex(arr1));
    System.out.println(findMiddleIndex(arr2));
    System.out.println(findMiddleIndex(arr3));
  }
}

package geeksforgeeks.arrays;

import java.util.ArrayList;

public class P1_SubarrayWithGivenSum {
  public static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
    ArrayList<Integer> res = new ArrayList<>();
    int left = 0, right = 0, curSum = arr[0];
    while (right < n) {
      if (curSum == s) {
        res.add(left + 1);
        res.add(right + 1);
        return res;
      } else {
        if (curSum < s) {
          if (right + 1 < n) {
            right++;
            curSum += arr[right];
          } else {
            res.add(-1);
            return res;
          }
        } else {
          curSum -= arr[left];
          left++;
        }
      }
    }
    res.add(-1);
    return res;
  }

  public static void main(String[] args) {
    System.out.println(subArraySum(new int[] {1, 2, 3, 7, 5}, 5, 12));
    System.out.println(subArraySum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 15));
  }
}

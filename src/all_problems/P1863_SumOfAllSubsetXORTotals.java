package all_problems;

public class P1863_SumOfAllSubsetXORTotals {
  int sum = 0;

  public int subsetXORSum(int[] nums) {
    sum = 0;
    return getAns(nums, 0, 0);
  }

  public int getAns(int[] arr, int i, int cur) {
    if (i == arr.length) {
      return cur;
    }
    return getAns(arr, i + 1, cur ^ arr[i]) + getAns(arr, i + 1, cur);
  }
}

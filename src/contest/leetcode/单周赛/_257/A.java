package contest.leetcode.单周赛._257;

public class A {
  public static int countQuadruplets(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 1; j < nums.length; j++) {
        for (int k = 2; k < nums.length; k++) {
          for (int l = 3; l < nums.length; l++) {
            if (i < j && j < k && k < l && nums[i] + nums[j] + nums[k] == nums[l]) {
              count++;
            }
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countQuadruplets(new int[] {1, 1, 1, 3, 5}));
  }
}

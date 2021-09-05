package leetcode500.p33_others.plan1;

public class P169_MajorityElement {
  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) return -1;
    int res = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == res) {
        count++;
      } else {
        count--;
      }
      if (count == 0) {
        res = nums[i];
        count++;
      }
    }
    return res;
  }
}

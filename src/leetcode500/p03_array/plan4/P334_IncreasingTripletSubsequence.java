package leetcode500.p03_array.plan4;

public class P334_IncreasingTripletSubsequence {
  public boolean increasingTriplet(int[] nums) {
    int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num <= small) small = num;
      else if (num <= big) big = num;
      else return true;
    }
    return false;
  }
}

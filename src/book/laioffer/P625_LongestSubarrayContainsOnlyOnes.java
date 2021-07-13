package book.laioffer;

public class P625_LongestSubarrayContainsOnlyOnes {
  public int longestConsecutiveOnes(int[] nums, int k) {
    int slow = 0;
    int fast = 0;
    int count = 0;
    int longest = 0;
    while (fast < nums.length) {
      if (nums[fast] == 1) {
        longest = Math.max(longest, ++fast - slow);
      } else if (count < k) {
        count++;
        longest = Math.max(longest, ++fast - slow);
      } else if (nums[slow++] == 0) {
        count--;
      }
    }
    return longest;
  }
}

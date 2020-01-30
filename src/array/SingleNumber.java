package array;

// Input: [2,2,1]
// Output: 1

// Input: [4,1,2,1,2]
// Output: 4
public class SingleNumber {
  public static int singleNumber(int[] nums) {
    int res = 0;
    for (int num : nums) {
      res ^= num;
    }
    return res;
  }

  public static void main(String[] args) {
    int[] input = new int[]{4, 1, 2, 1, 2};
    System.out.println(singleNumber(input));
  }
}

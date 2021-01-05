package data_structures.array;

// Given an data_structures.array nums, write a function to move all 0's to the end of it while maintaining the
// relative order of the non-zero elements.
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]

import java.util.Arrays;

public class MoveZeros {
  public static void moveZeroes(int[] nums) {
    int lastNotZero = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        swap(nums, i, lastNotZero++);
      }
    }
  }

  private static void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = {0, 1, 0 ,3, 12};
    moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}

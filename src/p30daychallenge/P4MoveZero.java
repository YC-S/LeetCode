package p30daychallenge;

import java.util.Arrays;

/**
 * @author shiyuanchen
 */
public class P4MoveZero {

	public static void moveZeros(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int[] res = new int[nums.length];
		for (int i = 0, j = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				res[j++] = nums[i];
			}
		}
		for (int i = 0; i < res.length; i++) {
			nums[i] = res[i];
		}
		return;
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeros(nums);
		System.out.println(Arrays.toString(nums));
	}
}

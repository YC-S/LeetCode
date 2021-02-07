package contest.leetcode.单周赛._227;

public class P5672_CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int start = 0;
        boolean unsorted = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            } else {
                start = i;
                unsorted = true;
                break;
            }
        }
        for (int j = start + 1; j < nums.length; j++) {
            if (nums[j] >= nums[j - 1]) {
                continue;
            } else {
                return false;
            }
        }
        if (!unsorted) {
            return true;
        }
        return unsorted && nums[nums.length - 1] <= nums[0];
    }
}

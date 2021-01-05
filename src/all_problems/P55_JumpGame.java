package all_problems;

public class P55_JumpGame {
    public static boolean canJump(int[] nums) {
        int last = nums.length - 1, i, j;
        for (i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return last <= 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}

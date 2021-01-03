import java.util.ArrayDeque;
import java.util.Deque;

public class P1673_FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peekFirst()] && nums.length - i + stack.size() > k) {
                stack.pollFirst();
            }
            if (stack.size() < k) {
                stack.offerFirst(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = nums[stack.pollFirst()];
        }
        return res;
    }
}

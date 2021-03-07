package contest.leetcode.单周赛._231;

public class P5698 {
    public static int minElements(int[] nums, int limit, int goal) {
        long curSum = 0;
        for (int num : nums) {
            curSum += num;
        }
        long diff = goal - curSum;
        return (int) Math.ceil(Math.abs(diff) / Math.abs((double) limit));
    }

    public static void main(String[] args) {
        System.out.println(minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println(minElements(new int[]{1, -10, 9, 1}, 100, 0));
    }
}

package company.wepay;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        try {
            System.out.println(new MaximumProductSubarray().maxProduct(null));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int maxProduct(int[] nums) throws Exception {
        if (nums == null) {
            throw new Exception("nums is null");
        }
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
            if (max > res) {
                res = max;
            }
        }
        return res;
    }
}

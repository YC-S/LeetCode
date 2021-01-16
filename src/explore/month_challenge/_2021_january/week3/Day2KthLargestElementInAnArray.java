package explore.month_challenge._2021_january.week3;

public class Day2KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1, target = nums.length - k;
        while (l < r) {
            int mid = quickSelect(nums, l, r);
            if (mid == target) {
                return nums[mid];
            } else if (mid < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }

    private int quickSelect(int[] nums, int l, int r) {
        int i = l, j = r;
        while (true) {
            while (i < r && nums[i] <= nums[l]) {
                ++i;
            }
            while (j > l && nums[j] >= nums[l]) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(i, j, nums);
        }
        swap(l, j, nums);
        return j;
    }

    private void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

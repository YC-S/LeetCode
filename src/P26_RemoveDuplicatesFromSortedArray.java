public class P26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int id = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[id++] = nums[i];
            }
        }
        return id;
    }
}

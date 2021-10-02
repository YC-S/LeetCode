package leetcode500.P09_bst.plan3;

public class P108_ConvertSortedArrayToBST {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;
    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int left, int right) {
    if (left > right) return null;
    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, left, mid - 1);
    root.right = helper(nums, mid + 1, right);
    return root;
  }
}

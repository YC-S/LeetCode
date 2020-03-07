import utility.TreeNode;

public class P98_ValidateBST {
	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private static boolean helper(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val < min || root.val > max) {
			return false;
		}
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		System.out.println(isValidBST(a));
	}
}

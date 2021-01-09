package explore.month_challenge._2021_january.week1;

import utility.TreeNode;

public class Day2FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return right;
    }
}

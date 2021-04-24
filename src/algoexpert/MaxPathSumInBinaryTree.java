package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPathSumInBinaryTree {
  public static int maxPathSum(BinaryTree tree) {
    // Write your code here.
    List<Integer> maxSumArray = findMaxSum(tree);
    return maxSumArray.get(1);
  }

  public static List<Integer> findMaxSum(BinaryTree tree) {
    if (tree == null) {
      return new ArrayList<>(Arrays.asList(0, Integer.MIN_VALUE));
    }
    List<Integer> leftMaxSumArray = findMaxSum(tree.left);
    int leftMaxSumAsBranch = leftMaxSumArray.get(0);
    int leftMaxPathSum = leftMaxSumArray.get(1);

    List<Integer> rightMaxSumArray = findMaxSum(tree.right);
    int rightMaxSumAsBranch = rightMaxSumArray.get(0);
    int rightMaxPathSum = rightMaxSumArray.get(1);

    int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
    int maxSumAsBranch = Math.max(maxChildSumAsBranch + tree.value, tree.value);
    int maxSumAsRootNode =
        Math.max(leftMaxSumAsBranch + tree.value + rightMaxSumAsBranch, maxSumAsBranch);
    int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));
    return new ArrayList<>(Arrays.asList(maxSumAsBranch, maxPathSum));
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}

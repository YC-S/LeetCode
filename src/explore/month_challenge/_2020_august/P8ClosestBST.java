/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_august;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/08
 */
public class P8ClosestBST {

  public void inorder(TreeNode root, List<Integer> nums) {
    if (root == null) {
      return;
    }
    inorder(root.left, nums);
    nums.add(root.val);
    inorder(root.right, nums);
  }

  public int closestValue(TreeNode root, double target) {
    List<Integer> nums = new ArrayList();
    inorder(root, nums);
    return Collections.min(nums, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
      }
    });
  }
}

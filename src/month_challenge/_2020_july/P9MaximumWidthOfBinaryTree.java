/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_july;

import utility.TreeNode;

import java.util.HashMap;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/09
 */
public class P9MaximumWidthOfBinaryTree {

  private Integer maxWidth = 0;
  private HashMap<Integer, Integer> firstColIndexTable;

  protected void DFS(TreeNode node, Integer depth, Integer colIndex) {
    if (node == null) {
      return;
    }
    // initialize the value, for the first seen colIndex per level
    if (!firstColIndexTable.containsKey(depth)) {
      firstColIndexTable.put(depth, colIndex);
    }
    Integer firstColIndex = firstColIndexTable.get(depth);

    maxWidth = Math.max(this.maxWidth, colIndex - firstColIndex + 1);

    // Preorder DFS. Note: it is important to put the priority on the left child
    DFS(node.left, depth + 1, 2 * colIndex);
    DFS(node.right, depth + 1, 2 * colIndex + 1);
  }

  public int widthOfBinaryTree(TreeNode root) {
    // table contains the first col_index for each level
    this.firstColIndexTable = new HashMap<>(10);

    // start from depth = 0, and colIndex = 0
    DFS(root, 0, 0);

    return this.maxWidth;
  }
}


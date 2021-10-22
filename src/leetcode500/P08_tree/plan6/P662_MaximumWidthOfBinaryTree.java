package leetcode500.P08_tree.plan6;

import java.util.LinkedList;
import java.util.Queue;

public class P662_MaximumWidthOfBinaryTree {
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(root, 0));
    long max = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      long curLeft = Long.MAX_VALUE;
      long curRight = Long.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        Pair curPair = queue.poll();
        TreeNode cur = curPair.node;
        long curIndex = curPair.index;
        if (cur.left != null) {
          queue.offer(new Pair(cur.left, curIndex * 2));
        }
        if (cur.right != null) {
          queue.offer(new Pair(cur.right, curIndex * 2 + 1));
        }
        curLeft = Math.min(curLeft, curIndex);
        curRight = Math.max(curRight, curIndex);
      }
      max = Math.max(curRight - curLeft + 1, max);
    }
    return (int) max;
  }

  private class Pair {
    TreeNode node;
    long index;

    public Pair(TreeNode node, long index) {
      this.node = node;
      this.index = index;
    }
  }
}

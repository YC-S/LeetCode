package leetcode500.P08_tree.plan4;

import java.util.*;

public class P742_ClosestLeafInABinaryTree {
  public int findClosestLeaf(TreeNode root, int k) {
    if (root.left == null && root.right == null) return root.val;

    // basic strategy: tree -> graph
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();

    // build graph
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    TreeNode startNode = null;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (!graph.containsKey(node)) {
        graph.put(node, new ArrayList<TreeNode>());
      }

      if (node.left != null) {
        graph.get(node).add(node.left);
        graph.putIfAbsent(node.left, new ArrayList<>());
        graph.get(node.left).add(node);
        queue.offer(node.left);
      }

      if (node.right != null) {
        graph.get(node).add(node.right);
        graph.putIfAbsent(node.right, new ArrayList<>());
        graph.get(node.right).add(node);
        queue.offer(node.right);
      }

      if (node.val == k) {
        startNode = node;
      }
    }

    // bfs to search shortest path
    queue.clear();
    queue.offer(startNode);
    Set<TreeNode> seen = new HashSet<>();
    seen.add(startNode);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node.left == null && node.right == null) return node.val;

      for (TreeNode neighbor : graph.get(node)) {
        if (seen.contains(neighbor)) continue;
        queue.offer(neighbor);
        seen.add(neighbor);
      }
    }
    return root.val;
  }
}

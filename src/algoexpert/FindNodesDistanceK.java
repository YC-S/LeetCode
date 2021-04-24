package algoexpert;

import java.util.ArrayList;

public class FindNodesDistanceK {
  public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
    // Write your code here.
    ArrayList<Integer> nodesDistanceK = new ArrayList<>();
    findDistanceFromNodeToTarget(tree, target, k, nodesDistanceK);
    return nodesDistanceK;
  }

  public int findDistanceFromNodeToTarget(
      BinaryTree node, int target, int k, ArrayList<Integer> nodesDistanceK) {
    if (node == null) return -1;
    if (node.value == target) {
      addSubtreeNodeAtDistanceK(node, 0, k, nodesDistanceK);
      return 1;
    }

    int leftDistance = findDistanceFromNodeToTarget(node.left, target, k, nodesDistanceK);
    int rightDistance = findDistanceFromNodeToTarget(node.right, target, k, nodesDistanceK);

    if (leftDistance == k || rightDistance == k) nodesDistanceK.add(node.value);

    if (leftDistance != -1) {
      addSubtreeNodeAtDistanceK(node.right, leftDistance + 1, k, nodesDistanceK);
      return leftDistance + 1;
    }

    if (rightDistance != -1) {
      addSubtreeNodeAtDistanceK(node.left, rightDistance + 1, k, nodesDistanceK);
      return rightDistance + 1;
    }
    return -1;
  }

  public void addSubtreeNodeAtDistanceK(
      BinaryTree node, int distance, int k, ArrayList<Integer> nodesDistanceK) {
    if (node == null) return;
    if (distance == k) {
      nodesDistanceK.add(node.value);
    } else {
      addSubtreeNodeAtDistanceK(node.left, distance + 1, k, nodesDistanceK);
      addSubtreeNodeAtDistanceK(node.right, distance + 1, k, nodesDistanceK);
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}

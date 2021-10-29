package leetcode500.P08_tree.plan9;

import java.util.ArrayDeque;
import java.util.Deque;

public class P536_ConstructBinaryTreeFromString {
  public TreeNode str2tree(String s) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    for (int i = 0, j = i; i < s.length(); i++, j = i) {
      char c = s.charAt(i);
      if (c == ')') stack.pollFirst();
      else if (c >= '0' && c <= '9' || c == '-') {
        while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
        TreeNode currentNode = new TreeNode(Integer.parseInt(s.substring(j, i + 1)));
        if (!stack.isEmpty()) {
          TreeNode parent = stack.peekFirst();
          if (parent.left != null) parent.right = currentNode;
          else parent.left = currentNode;
        }
        stack.offerFirst(currentNode);
      }
    }
    return stack.isEmpty() ? null : stack.peekFirst();
  }
}

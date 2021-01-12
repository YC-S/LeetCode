package all_problems;

import java.util.ArrayList;
import java.util.List;

public class P589_NAryTreePreorderTraversal {
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        if (root == null)
            return ans;
        ans.add(root.val);
        for (Node temp : root.children)
            preorder(temp);
        return ans;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

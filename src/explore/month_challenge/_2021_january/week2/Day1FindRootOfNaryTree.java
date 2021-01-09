package explore.month_challenge._2021_january.week2;

import java.util.ArrayList;
import java.util.List;

public class Day1FindRootOfNaryTree {
    public Node findRoot(List<Node> tree) {
        // Edge Case
        if (tree == null || tree.size() == 0) return null;

        long sum = 0;

        // For each node in the tree
        for (Node node : tree) {
            // Add current node value to sum
            sum ^= node.val;

            // For each child - reduce value of child from sum
            for (Node child : node.children)
                sum ^= child.val;
        }

        // Remaining value in sum is the only node that doesn't have a parent (meaning isn't a child of any other node) - which is the root.
        for (Node node : tree)
            if (node.val == sum) return node;

        return null;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}

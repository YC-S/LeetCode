package all_problems;

public class P510_InorderSuccessorInBSTII {
    public Node inorderSuccessor(Node node) {
        Node result;
        if (node.right == null) {
            result = node.parent;
            while (result != null && result.val < node.val) {
                result = result.parent;
            }
        } else {
            result = node.right;
            while (result.left != null) {
                result = result.left;
            }
        }
        return result;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}

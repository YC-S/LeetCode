package all_problems;

public class P1612_CheckIfTwoExpressionTreesAreEquivalent {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] map = new int[26];
        addToMap(root1, map, 1);
        addToMap(root2, map, -1);
        for (int val : map)
            if (val != 0)
                return false;
        return true;
    }

    private void addToMap(Node root, int[] map, int add) {
        if (root == null)
            return;
        if (root.val <= 'z' && root.val >= 'a')
            map[root.val - 'a'] += add;

        addToMap(root.left, map, add);
        addToMap(root.right, map, add);
    }

    class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

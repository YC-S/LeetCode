package all_problems;

public class P558_LogicalOrOfTwoBinaryGridsRepresentedAsQuadTrees {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null || quadTree2.isLeaf && quadTree2.val || quadTree1.isLeaf && !quadTree1.val)
            return quadTree2;
        if (quadTree2 == null || quadTree1.isLeaf && quadTree1.val || quadTree2.isLeaf && !quadTree2.val)
            return quadTree1;
        Node res = new Node();
        res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf) {
            if (res.topLeft.val && res.topRight.val && res.bottomLeft.val && res.bottomRight.val)
                return new Node(true, true);
            else if (!res.topLeft.val && !res.topRight.val && !res.bottomLeft.val && !res.bottomRight.val)
                return new Node(true, false);
        }
        return res;
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}

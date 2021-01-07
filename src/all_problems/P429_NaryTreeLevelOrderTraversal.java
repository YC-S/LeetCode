package all_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<all_problems.Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<all_problems.Node> _children) {
        val = _val;
        children = _children;
    }
}

public class P429_NaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();

        if (root == null) return ret;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }

        return ret;
    }
}

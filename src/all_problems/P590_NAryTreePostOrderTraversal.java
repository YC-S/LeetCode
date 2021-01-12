package all_problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P590_NAryTreePostOrderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> que = new LinkedList<>();
        if (root == null)
            return res;
        que.add(root);
        while (!que.isEmpty()) {
            int ize = que.size();
            Node node = que.removeLast();
            res.add(0, node.val);
            for (Node child : node.children) {
                que.add(child);
            }
        }
        return res;
    }
}

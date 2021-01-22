package all_problems;

import java.util.LinkedList;
import java.util.List;

public class P1104_PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new LinkedList<>();
        if (label <= 0)
            return result;
        int level = 0;
        while (Math.pow(2, level) - 1 < label) level++;
        level--; // calculate the depth, 0 indexed, 0 is odd
        while (level != 0) {
            result.add(0, label);
            int pos = label - (int) Math.pow(2, level); // calculate the position, 0 indexed
            label = label - (pos + 1) - pos / 2;
            level--;
        }
        result.add(0, 1);
        return result;
    }
}

package all_problems;

import java.util.HashSet;
import java.util.Set;

public class P1361_ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;
            visited.add(i);
            boolean valid = traverse(visited, rootSet, i, leftChild, rightChild);
            rootSet.add(i);
            if (!valid) return false;
        }
        return visited.size() == n && rootSet.size() == 1;
    }

    private boolean traverse(Set<Integer> visited, Set<Integer> rootSet, int cur, int[] leftChild, int[] rightChild) {
        int left = leftChild[cur];
        int right = rightChild[cur];
        if (left != -1) {
            if (!visited.contains(left)) {
                visited.add(left);
                if (!traverse(visited, rootSet, left, leftChild, rightChild)) return false;
            } else {
                if (rootSet.contains(left)) {
                    rootSet.remove(left);
                } else {
                    return false;
                }
            }
        }
        if (right != -1) {
            if (!visited.contains(right)) {
                visited.add(right);
                return traverse(visited, rootSet, right, leftChild, rightChild);
            } else {
                if (rootSet.contains(right)) {
                    rootSet.remove(right);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

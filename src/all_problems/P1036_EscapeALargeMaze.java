package all_problems;

import java.util.HashSet;
import java.util.Set;

public class P1036_EscapeALargeMaze {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) return true;
        Set<Integer> blocks = new HashSet();
        for (int[] b : blocked)
            if (target[0] * 1000000 + target[1] != b[0] * 1000000 + b[1])
                blocks.add(b[0] * 1000000 + b[1]);
        return dfs(blocks, source, source[0], source[1], new HashSet<Integer>(), target) && dfs(blocks, target, target[0], target[1], new HashSet<Integer>(), source);
    }

    public boolean dfs(Set<Integer> blocks, int[] start, int i, int j, Set<Integer> visited, int[] target) {
        if (i < 0 || j < 0 || i > 999999 || j > 999999 || blocks.contains(i * 1000000 + j) || visited.contains(i * 1000000 + j))
            return false;
        if (i == target[0] && j == target[1]) return true;
        visited.add(i * 1000000 + j);
        if (visited.size() > blocks.size() * (blocks.size() + 1))
            return true;
        return dfs(blocks, start, i + 1, j, visited, target) || dfs(blocks, start, i - 1, j, visited, target) || dfs(blocks, start, i, j + 1, visited, target) || dfs(blocks, start, i, j - 1, visited, target);
    }
}

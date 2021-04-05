package all_problems;

import java.util.Arrays;

public class P684_RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int[] edge : edges) {
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t)) return edge;
            else parent[find(parent, f)] = find(parent, t);
        }

        return new int[2];
    }

    private static int find(int[] parent, int f) {
        if (f != parent[f]) {
            parent[f] = find(parent, parent[f]);
        }
        return parent[f];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
    }
}

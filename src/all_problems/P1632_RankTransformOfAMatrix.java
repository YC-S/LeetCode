package all_problems;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P1632_RankTransformOfAMatrix {
    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rank = new int[n + m];
        Map<Integer, List<Pair<Integer, Integer>>> invMap = new TreeMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                invMap.computeIfAbsent(matrix[i][j], l -> new ArrayList<>()).add(new Pair<>(i, j));
        for (int key : invMap.keySet()) {
            UF uf = new UF(n + m);
            int[] rank2 = rank.clone();
            for (Pair<Integer, Integer> coord : invMap.get(key)) {
                Pair<Integer, Integer> res = uf.union(coord.getKey(), coord.getValue() + n);
                rank2[res.getValue()] = Math.max(rank2[res.getValue()], rank2[res.getKey()]);
            }
            for (Pair<Integer, Integer> coord : invMap.get(key))
                rank[coord.getKey()] = rank[coord.getValue() + n]
                        = matrix[coord.getKey()][coord.getValue()]
                        = rank2[uf.find(coord.getKey())] + 1;
        }
        return matrix;
    }
}

class UF {
    int[] parent;

    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        return parent[x] = parent[x] == x ? x : find(parent[x]);
    }

    public Pair<Integer, Integer> union(int x, int y) {
        int px = find(x);
        int py = find(y);
        parent[px] = py;
        return new Pair<>(px, py);
    }
}


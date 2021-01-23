package all_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1273_DeleteTreeNodes {
    int countOfZeroSubtreeNode = 0;

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        Map<Integer, List<Integer>> graph = new HashMap();

        for (int i = 0; i < parent.length; i++)
            graph.computeIfAbsent(parent[i], key -> new ArrayList()).add(i);

        int[] result = dfs(graph, graph.get(-1).get(0), parent, value);
        return nodes - countOfZeroSubtreeNode;
    }

    public int[] dfs(Map<Integer, List<Integer>> graph, int node, int[] parent, int[] value) {
        int[] result = new int[]{value[node], 1};

        for (Integer neighbour : graph.getOrDefault(node, new ArrayList<Integer>())) {
            int[] dfsResult = dfs(graph, neighbour, parent, value);
            result[0] += dfsResult[0];  //sum of the current subtree
            result[1] += dfsResult[1]; // count of the current subtree
        }

        if (result[0] == 0)// sum = 0 , pruning the subtree so returning [0,0] so that it is not counted again
        {
            countOfZeroSubtreeNode += result[1];
            return new int[2];
        }
        return result;
    }
}

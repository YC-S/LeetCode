package leetcode500.p17_graph_traversal.plan1;

public class P323_NumberOfConnectedComponentsInAnUndirectedGraph {
  public int countComponents(int n, int[][] edges) {
    int[] roots = new int[n];
    for (int i = 0; i < n; i++) roots[i] = i;
    for (int[] edge : edges) {
      int root1 = find(roots, edge[0]);
      int root2 = find(roots, edge[1]);
      if (root1 != root2) {
        roots[root1] = root2;
        n--;
      }
    }
    return n;
  }

  private int find(int[] roots, int id) {
    if (roots[id] == id) return id;
    roots[id] = find(roots, roots[id]);
    return roots[id];
  }
}

package leetcode500.p17_graph_traversal.plan1;

public class P547_NumberOfProvinces {
  public int findCircleNum(int[][] isConnected) {
    int[] visited = new int[isConnected.length];
    int count = 0;
    for (int i = 0; i < isConnected.length; i++) {
      if (visited[i] == 0) {
        count++;
        dfs(isConnected, visited, i);
      }
    }
    return count;
  }

  private void dfs(int[][] isConnected, int[] visited, int i) {
    for (int j = 0; j < isConnected[i].length; j++) {
      if (isConnected[i][j] == 1 && visited[j] == 0) {
        visited[j] = 1;
        dfs(isConnected, visited, j);
      }
    }
  }
}

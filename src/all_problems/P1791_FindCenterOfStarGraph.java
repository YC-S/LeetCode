package all_problems;

public class P1791_FindCenterOfStarGraph {
  public int findCenter(int[][] edges) {
    return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
  }
}

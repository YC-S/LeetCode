package leetcode500.p17_graph_traversal.plan3;

import java.util.Arrays;

public class MN {
  int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) {
    MN solution = new MN();
    int[][] grid = new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    int[][] res = solution.floodFill(grid, 1, 1, 2);
    for (int[] arr : res) {
      System.out.println(Arrays.toString(arr));
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int original = image[sr][sc];
    image[sr][sc] = newColor;
    for (int[] dir : dirs) {
      dfs(image, sr + dir[0], sc + dir[1], newColor, original);
    }
    return image;
  }

  private void dfs(int[][] image, int i, int j, int newColor, int original) {
    if (i < 0
        || i >= image.length
        || j < 0
        || j >= image[0].length
        || image[i][j] == newColor
        || (image[i][j] != newColor && image[i][j] != original)) return;
    if (image[i][j] == original) image[i][j] = newColor;
    for (int[] dir : dirs) {
      dfs(image, i + dir[0], j + dir[1], newColor, original);
    }
  }
}

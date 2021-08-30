package leetcode500.p27_segment_tree.plan1;

public class P308_RangeSumQuery2D_Mutable {
  int[][] matrix;
  int[][] tree;

  public P308_RangeSumQuery2D_Mutable(int[][] matrix) {
    this.matrix = matrix;
    int m = matrix.length;
    int n = matrix[0].length;
    tree = new int[m][n + 1];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        updateTree(i, j, matrix[i][j]);
      }
    }
  }

  public void update(int row, int col, int val) {
    int delta = val - matrix[row][col];
    matrix[row][col] = val;
    updateTree(row, col, delta);
  }

  private void updateTree(int row, int col, int delta) {
    int[] temp = tree[row];
    int i = col + 1;
    while (i < temp.length) {
      temp[i] += delta;
      i += lowbit(i);
    }
  }

  private int lowbit(int i) {
    return i & (-i);
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int i = row1; i <= row2; i++) {
      sum += (query(i, col2) - query(i, col1 - 1));
    }
    return sum;
  }

  public int query(int row, int col) {
    int[] temp = tree[row];

    int i = col + 1;
    int sum = 0;
    while (i > 0) {
      sum += temp[i];
      i -= lowbit(i);
    }
    return sum;
  }
}

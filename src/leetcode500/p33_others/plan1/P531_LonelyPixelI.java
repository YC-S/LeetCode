package leetcode500.p33_others.plan1;

public class P531_LonelyPixelI {
  public int findLonelyPixel(char[][] picture) {
    int numRows = picture.length;
    int numColumns = picture[0].length;

    int[] rows = new int[numRows];
    int[] cols = new int[numColumns];
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        if (picture[i][j] == 'B') {
          rows[i] += 1;
          cols[j] += 1;
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        if (picture[i][j] == 'B' && rows[i] <= 1 && cols[j] <= 1) ans += 1;
      }
    }

    return ans;
  }
}

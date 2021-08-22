package contest.leetcode.单周赛._255;

public class C {
  public static void main(String[] args) {
    System.out.println(
        new C().minimizeTheDifference(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 13));
  }

  public int minimizeTheDifference(int[][] mat, int target) {
    int[] indices = new int[mat.length];

    int currentIndex = indices.length - 1;
    int min = Integer.MAX_VALUE;
    outerProcess:
    while (true) {
      int cur = 0;
      for (int i = 0; i < mat.length; i++) {
        cur += mat[i][indices[i]];
      }
      min = Math.min(Math.abs(cur - target), min);

      while (true) {
        // Increase current index
        indices[currentIndex]++;
        // If index too big, set itself and everything right of it to 0 and move left
        if (indices[currentIndex] >= mat[currentIndex].length) {
          for (int j = currentIndex; j < indices.length; j++) {
            indices[j] = 0;
          }
          currentIndex--;
        } else {
          // If index is allowed, move as far right as possible and process next
          // combination
          while (currentIndex < indices.length - 1) {
            currentIndex++;
          }
          break;
        }
        // If we cannot move left anymore, we're finished
        if (currentIndex == -1) {
          break outerProcess;
        }
      }
    }
    return min;
  }
}

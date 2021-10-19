package leetcode500.P16_dfs.plan5;

public class P1079_LetterTilePossibilities {
  public int numTilePossibilities(String tiles) {
    int[] count = new int[26];
    for (char c : tiles.toCharArray()) count[c - 'A']++;
    int[] sum = {0};
    dfs(count, sum);
    return sum[0];
  }

  private void dfs(int[] arr, int[] sum) {
    for (int i = 0; i < 26; i++) {
      if (arr[i] == 0) continue;
      sum[0]++;
      arr[i]--;
      dfs(arr, sum);
      arr[i]++;
    }
  }
}

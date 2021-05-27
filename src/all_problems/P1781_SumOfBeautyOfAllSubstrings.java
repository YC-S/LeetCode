package all_problems;

public class P1781_SumOfBeautyOfAllSubstrings {
  private int getMinCount(int[] charCount) {
    int min = Integer.MAX_VALUE;

    for (int j : charCount) {
      if (j != 0) {
        min = Math.min(min, j);
      }
    }

    return min;
  }

  private int getMaxCount(int[] charCount) {
    int max = 0;

    for (int j : charCount) {
      max = Math.max(max, j);
    }

    return max;
  }

  public int beautySum(String s) {
    int sum = 0;

    for (int i = 0; i < s.length(); ++i) {
      int[] charCount = new int[26]; // initialize charCount to all 0

      for (int j = i; j < s.length(); ++j) {
        ++charCount[s.charAt(j) - 'a'];

        // get beauty of substring from i to j
        int beauty = getMaxCount(charCount) - getMinCount(charCount);
        sum += beauty;
      }
    }

    return sum;
  }
}

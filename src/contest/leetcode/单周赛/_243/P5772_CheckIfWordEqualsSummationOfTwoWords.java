package contest.leetcode.单周赛._243;

public class P5772_CheckIfWordEqualsSummationOfTwoWords {
  public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    int a = helper(firstWord);
    int b = helper(secondWord);
    int c = helper(targetWord);
    return a + b == c;
  }

  private int helper(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      sb.append(c - 'a');
    }
    return Integer.parseInt(sb.toString());
  }
}

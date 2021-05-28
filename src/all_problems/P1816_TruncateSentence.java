package all_problems;

public class P1816_TruncateSentence {
  public String truncateSentence(String s, int k) {
    String[] str = s.split(" ");
    StringBuilder truncatedSentence = new StringBuilder();
    for (int i = 0; i < k - 1; i++) {
      truncatedSentence.append(str[i]).append(" ");
    }
    truncatedSentence.append(str[k - 1]); // because we don't want  space for last word
    return truncatedSentence.toString();
  }
}

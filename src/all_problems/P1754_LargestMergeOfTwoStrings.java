package all_problems;

public class P1754_LargestMergeOfTwoStrings {
  public String largestMerge(String word1, String word2) {
    if (word1.length() == 0 || word2.length() == 0) return word1 + word2;
    if (word1.compareTo(word2) > 0)
      return word1.charAt(0) + largestMerge(word1.substring(1), word2);
    return word2.charAt(0) + largestMerge(word1, word2.substring(1));
  }
}

package leetcode500.P14_hybrid_data_structure.plan2;

public class P245_ShortestWordDistanceIII {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        i1 = i;
      }
      if (words[i].equals(word2)) {
        if (word1.equals(word2)) {
          i1 = i2;
        }
        i2 = i;
      }
      dist = Math.min(dist, Math.abs(i1 - i2));
    }
    return (int) dist;
  }
}

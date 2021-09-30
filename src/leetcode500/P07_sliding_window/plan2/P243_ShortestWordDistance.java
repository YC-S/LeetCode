package leetcode500.P07_sliding_window.plan2;

public class P243_ShortestWordDistance {
  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    int p1 = -1;
    int p2 = -1;
    int dis = Integer.MAX_VALUE;
    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1)) {
        p1 = i;
      }
      if (wordsDict[i].equals(word2)) {
        p2 = i;
      }
      if (p1 != -1 && p2 != -1) {
        dis = Math.min(dis, Math.abs(p2 - p1));
      }
    }
    return dis;
  }
}

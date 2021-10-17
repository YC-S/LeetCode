package leetcode500.p06_string.plan5;

import java.util.List;

public class P422_ValidWordSquare {
  public boolean validWordSquare(List<String> words) {
    int max = 0;
    for (String word : words) {
      max = Math.max(word.length(), max);
    }
    if (words.size() != max) return false;
    char[][] matrix = new char[words.size()][max];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < words.get(i).length(); j++) {
        matrix[i][j] = words.get(i).charAt(j);
      }
    }
    for (int row = 0; row < words.size(); row++) {
      for (int col = row; col < words.size(); col++) {
        if (matrix[row][col] != matrix[col][row]) return false;
      }
    }
    return true;
  }
}

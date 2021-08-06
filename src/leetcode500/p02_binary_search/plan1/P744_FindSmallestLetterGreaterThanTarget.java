package leetcode500.p02_binary_search.plan1;

public class P744_FindSmallestLetterGreaterThanTarget {
  public char nextGreatestLetter(char[] letters, char target) {
    int n = letters.length;
    if (target >= letters[n - 1]) return letters[0];
    int left = 0, right = n - 1;
    while (left < right - 1) {
      int mid = (left + right) >>> 1;
      if (letters[mid] <= target) left = mid;
      else if (letters[mid] == target) return letters[mid];
      else right = mid;
    }
    if (letters[left] > target) return letters[left];
    else return letters[right];
  }
}

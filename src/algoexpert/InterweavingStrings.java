package algoexpert;

public class InterweavingStrings {
  public static boolean interweavingStrings(String one, String two, String three) {
    // Write your code here.
    if (three.length() != one.length() + two.length()) {
      return false;
    }
    return areInterwoven(one, two, three, 0, 0);
  }

  public static boolean areInterwoven(String one, String two, String three, int i, int j) {
    int k = i + j;
    if (k == three.length()) return true;
    if (i < one.length() && one.charAt(i) == three.charAt(k)) {
      if (areInterwoven(one, two, three, i + 1, j)) return true;
    }
    if (j < two.length() && two.charAt(j) == three.charAt(k)) {
      return areInterwoven(one, two, three, i, j + 1);
    }
    return false;
  }
}

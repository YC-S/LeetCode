package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class MultiStringSearch {
  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
    // Write your code here.
    List<Boolean> solution = new ArrayList<>();
    for (String smallString : smallStrings) {
      solution.add(isInBigString(bigString, smallString));
    }
    return solution;
  }

  public static boolean isInBigString(String bigString, String smallString) {
    for (int i = 0; i < bigString.length(); i++) {
      if (i + smallString.length() > bigString.length()) {
        break;
      }
      if (isInBigString(bigString, smallString, i)) {
        return true;
      }
    }
    return false;
  }

  public static boolean isInBigString(String bigString, String smallString, int startIdx) {
    int leftBigIdx = startIdx;
    int rightBigIdx = startIdx + smallString.length() - 1;
    int leftSmallIdx = 0;
    int rightSmallIdx = smallString.length() - 1;
    while (leftBigIdx <= rightBigIdx) {
      if (bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx)
          || bigString.charAt(rightBigIdx) != smallString.charAt(rightSmallIdx)) {
        return false;
      }
      leftBigIdx++;
      rightBigIdx--;
      leftSmallIdx++;
      rightSmallIdx--;
    }
    return true;
  }
}

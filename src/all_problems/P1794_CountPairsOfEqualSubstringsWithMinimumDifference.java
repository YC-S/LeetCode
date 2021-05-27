package all_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1794_CountPairsOfEqualSubstringsWithMinimumDifference {
  public int countQuadruples(String firstString, String secondString) {
    Map<Character, Integer> firstMap = new HashMap<>();
    Map<Character, Integer> secondMap = new HashMap<>();

    // Find first occurrence of each char in first string
    for (int i = 0; i < firstString.length(); i++) {
      if (!firstMap.containsKey(firstString.charAt(i))) {
        firstMap.put(firstString.charAt(i), i);
      }
    }

    // Find last occurrence of each char in second string
    for (int i = 0; i < secondString.length(); i++) {
      secondMap.put(secondString.charAt(i), i);
    }

    // Find common chars in string and compute (j-a) and store in map<(j-a), set of chars with j-a
    // distance>.
    Map<Integer, Set<Character>> minMap = new HashMap<>();
    int minDistance = Integer.MAX_VALUE;
    int minLength = Math.min(firstString.length(), secondString.length());
    for (int i = 0; i < minLength; i++) {
      char firstChar = firstString.charAt(i);
      if (secondMap.containsKey(firstChar)) {
        int j = firstMap.get(firstChar);
        int a = secondMap.get(firstChar);
        if ((j - a) > minDistance) {
          continue;
        }
        Set<Character> currentList = new HashSet<>();
        if (minMap.containsKey(j - a)) {
          currentList = minMap.get(j - a);
        }
        currentList.add(firstChar);
        minMap.put(j - a, currentList);
        minDistance = Math.min(minDistance, j - a);
      }
    }

    // Get the count of total chars with min j-a distance
    Set<Character> result = minMap.get(minDistance);

    return result == null ? 0 : result.size();
  }
}

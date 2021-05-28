package all_problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P1805_NumberOfDifferentIntegersInAString {
  public int numDifferentIntegers(String word) {
    return Arrays.stream(word.replaceAll("[a-z]+", " ").split(" "))
        .filter(s -> !"".equals(s))
        .map(s -> s.replaceFirst("^0+", ""))
        .collect(Collectors.toSet())
        .size();
  }
}

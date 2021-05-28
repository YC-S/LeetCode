package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P1830_MinimumNumberOfOperationsToMakeStringSorted {
  public int modulo = 1000000007;
  Map<Integer, Long> factorMemo = new HashMap<>();

  public int makeStringSorted(String s) {
    int[] occurrences = new int[26];
    populateOccurrences(occurrences, s);
    int totalLength = s.length();

    long result = 0;
    long possibilities = numberOfPossibilities(occurrences, totalLength, modulo);
    while (totalLength > 1) {
      // We start calculating after the first step
      if (totalLength < s.length()) {
        int previousOccurrences = occurrences[s.charAt(s.length() - totalLength - 1) - 'a'] + 1;
        possibilities =
            modDivide((possibilities * previousOccurrences) % modulo, totalLength + 1, modulo);
      }
      char c = s.charAt(s.length() - totalLength);
      int numberOfOccurrencesBefore = numberOfOccurrencesBefore(occurrences, c);
      long currentResult =
          modDivide((possibilities * numberOfOccurrencesBefore) % modulo, totalLength, modulo);
      occurrences[c - 'a'] -= 1;
      result = (result + currentResult) % modulo;
      totalLength--;
    }

    return (int) result;
  }

  public void populateOccurrences(int[] occurrences, String s) {
    for (char c : s.toCharArray()) {
      occurrences[c - 'a'] += 1;
    }
  }

  public int numberOfOccurrencesBefore(int[] occurrences, char character) {
    int result = 0;
    for (int i = 0; i < character - 'a'; i++) {
      result += occurrences[i];
    }
    return result;
  }

  public long numberOfPossibilities(int[] occurrences, int totalSum, int mod) {
    long result = modFact(totalSum, mod);
    for (int occurrence : occurrences) {
      result = modDivide(result, modFact(occurrence, mod), mod);
    }
    return result;
  }

  public long modDivide(long a, long b, int mod) {
    b = modPow(b, mod - 2, mod);
    return ((a % mod) * b) % mod;
  }

  public long modFact(int n, int mod) {
    if (factorMemo.get(n) != null) {
      return factorMemo.get(n);
    }
    long result = 1;
    for (int i = 1; i <= n; i++) {
      // We can simplify (i%mod) by i, because i < mod (and will always be).
      result = (result * i) % mod;
      factorMemo.put(i, result);
    }
    factorMemo.put(n, result);
    return result;
  }

  public long modPow(long base, int exponent, int modulus) {
    if (modulus == 1) {
      return 0;
    }
    long result = 1;
    base = base % modulus;

    while (exponent > 0) {
      if (exponent % 2 == 1) {
        result = (result * base) % modulus;
      }
      exponent = exponent >> 1;
      base = (base * base) % modulus;
    }
    return result;
  }
}

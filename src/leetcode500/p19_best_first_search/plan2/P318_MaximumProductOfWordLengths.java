package leetcode500.p19_best_first_search.plan2;

public class P318_MaximumProductOfWordLengths {
  public int bitNumber(char ch) {
    return (int) ch - (int) 'a';
  }

  public int maxProduct(String[] words) {
    int n = words.length;
    int[] masks = new int[n];
    int[] lens = new int[n];

    int bitmask = 0;
    for (int i = 0; i < n; ++i) {
      bitmask = 0;
      for (char ch : words[i].toCharArray()) {
        // add bit number bit_number in bitmask
        bitmask |= 1 << bitNumber(ch);
      }
      masks[i] = bitmask;
      lens[i] = words[i].length();
    }

    int maxVal = 0;
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n; j++)
        if ((masks[i] & masks[j]) == 0) maxVal = Math.max(maxVal, lens[i] * lens[j]);

    return maxVal;
  }
}

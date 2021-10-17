package leetcode500.p06_string.plan5;

public class P443_StringCompression {
  public int compress(char[] chars) {
    if (chars == null || chars.length == 0) return 0;
    int index = 0, n = chars.length, i = 0;
    while (i < n) {
      char ch = chars[i];
      int j = i;
      while (j < n && chars[i] == chars[j]) { // chars[i..j - 1] are ch.
        j++;
      }
      int freq = j - i; // The frequency of ch.
      chars[index++] = ch;
      if (freq == 1) {
        i = j;
        continue;
      } else if (freq < 10) {
        chars[index++] = (char) (freq + '0');
      } else {
        String strFreq = String.valueOf(freq);
        for (char chFreq : strFreq.toCharArray()) chars[index++] = chFreq;
      }
      i = j;
    }
    return index;
  }
}

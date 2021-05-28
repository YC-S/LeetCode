package all_problems;

public class P1869_LongerContiguousSegmentsOfOnesThanZeros {
  public boolean checkZeroOnes(String s) {
    int count0 = 0, count1 = 0, max0 = 0, max1 = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        count1 = 0;
        count0++;
        max0 = Math.max(max0, count0);
      } else {
        count0 = 0;
        count1++;
        max1 = Math.max(max1, count1);
      }
    }
    return (max1 > max0);
  }
}

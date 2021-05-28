package all_problems;

public class P1826_FaultySensor {
  public int badSensor(int[] s1, int[] s2) {
    for (int i = 0, sz = s1.length; i + 1 < sz; ++i)
      if (s1[i] != s2[i]) {
        if (s1[i] == s1[sz - 1] && s2[i] == s2[sz - 1]) return -1;
        while (i + 1 < sz && s1[i] == s2[i + 1]) ++i;
        return i + 1 == sz ? 1 : 2;
      }
    return -1;
  }
}

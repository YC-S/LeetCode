package all_problems;

import java.util.ArrayList;
import java.util.List;

public class P1790_CheckIfOneStringSwapCanMakeStringsEqual {
  public boolean areAlmostEqual(String s1, String s2) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) list.add(i);
      if (list.size() > 2) return false;
    }
    return list.size() == 0
        || (list.size() == 2
            && s1.charAt(list.get(0)) == s2.charAt(list.get(1))
            && s1.charAt(list.get(1)) == s2.charAt(list.get(0)));
  }
}

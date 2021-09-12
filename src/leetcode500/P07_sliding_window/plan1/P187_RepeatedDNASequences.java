package leetcode500.P07_sliding_window.plan1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P187_RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
    for (int i = 0; i + 9 < s.length(); i++) {
      String ten = s.substring(i, i + 10);
      if (!seen.add(ten)) repeated.add(ten);
    }
    return new ArrayList<>(repeated);
  }
}

package laicode.dfsII;

import java.util.ArrayList;
import java.util.List;

public class CombinationsForTelephonePadI {
  String[][] refer = {
    {""},
    {""},
    {"a", "b", "c"},
    {"d", "e", "f"},
    {"g", "h", "i"},
    {"j", "k", "l"},
    {"m", "n", "o"},
    {"p", "q", "r", "s"},
    {"t", "u", "v"},
    {"w", "x", "y", "z"}
  };

  public String[] combinations(int number) {
    String digits = String.valueOf(number);
    List<String> list = new ArrayList<>();
    if (!digits.equals("")) {
      helper(list, digits, "");
      return convert(list);
    }
    return convert(list);
  }

  private String[] convert(List<String> list) {
    String[] res = new String[list.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = list.get(i);
    }
    return res;
  }

  private void helper(List<String> list, String digits, String s) {
    if (digits.length() == 0) {
      list.add(s);
      return;
    }
    int idx = Integer.parseInt(digits.substring(0, 1));
    for (String k : refer[idx]) {
      helper(list, digits.substring(1), s + k);
    }
  }
}

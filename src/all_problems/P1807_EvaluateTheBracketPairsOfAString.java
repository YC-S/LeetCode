package all_problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1807_EvaluateTheBracketPairsOfAString {
  public String evaluate(String s, List<List<String>> knowledge) {
    Map<String, String> map = new HashMap<>();
    for (List<String> list : knowledge) {
      map.put(list.get(0), list.get(1));
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        int j = i;
        while (j < s.length() && s.charAt(j) != ')') j++;
        sb.append(map.getOrDefault(s.substring(i + 1, j), "?"));
        i = j;
      } else sb.append(c);
    }
    return sb.toString();
  }
}

package leetcode500.p06_string.plan5;

import java.util.ArrayList;
import java.util.List;

public class P271_EncodeAndDecodeStrings {
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(s.length()).append('/').append(s);
    }
    return sb.toString();
  }

  public List<String> decode(String s) {
    List<String> res = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
      int slash = s.indexOf('/', i);
      int size = Integer.parseInt(s.substring(i, slash));
      i = slash + size + 1;
      res.add(s.substring(slash + 1, i));
    }
    return res;
  }
}

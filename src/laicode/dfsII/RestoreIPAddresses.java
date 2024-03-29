package laicode.dfsII;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
  public List<String> Restore(String ip) {
    List<String> res = new ArrayList<>();
    int len = ip.length();
    for (int i = 1; i < 4 && i < len - 2; i++) {
      for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
        for (int k = j + 1; k < j + 4 && k < len; k++) {
          String s1 = ip.substring(0, i),
              s2 = ip.substring(i, j),
              s3 = ip.substring(j, k),
              s4 = ip.substring(k, len);
          if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
          }
        }
      }
    }
    return res;
  }

  public boolean isValid(String s) {
    return s.length() <= 3
        && s.length() != 0
        && ((s.charAt(0) != '0' || s.length() <= 1) && Integer.parseInt(s) <= 255);
  }
}

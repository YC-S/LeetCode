package leetcode500.p01_basic_coding.plan3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P247_StrobogrammaticNumberII {
  char[] pair = new char[10];
  char[] num = new char[] {'0', '1', '6', '8', '9'};

  public List<String> findStrobogrammatic(int n) {
    List<String> list = new ArrayList<>();
    if (n == 1) {
      return Arrays.asList("0", "1", "8");
    }
    pair[0] = '0';
    pair[1] = '1';
    pair[6] = '9';
    pair[8] = '8';
    pair[9] = '6';
    recur(0, n - 1, new char[n], list);
    return list;
  }

  public void recur(int i, int n, char[] arr, List<String> list) {
    if (i >= n) {
      if (i == n) {
        // for odd number of digits
        char[] special = new char[] {'0', '8', '1'};
        for (char x : special) {
          arr[i] = x;
          list.add(new String(arr));
        }
      } else list.add(new String(arr));
      return;
    }

    for (int k = 0; k < num.length; k++) {
      if (i == 0 && k == 0) continue;
      arr[i] = num[k];
      arr[n] = pair[num[k] - '0'];
      recur(i + 1, n - 1, arr, list);
    }
  }
}

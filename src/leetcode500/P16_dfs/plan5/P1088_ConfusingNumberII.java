package leetcode500.P16_dfs.plan5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1088_ConfusingNumberII {
  int[] arr = {0, 1, 6, 8, 9};
  int ans = 0;

  public int confusingNumberII(int N) {
    genNum(getDigitCount(N), N);
    return ans;
  }

  public List<Integer> genNum(int digits, int N) {
    if (digits == 1) {
      for (int a : arr) {
        if (a <= N && a != rotate(a)) ans++;
      }
      return new ArrayList<>(Arrays.asList(0, 1, 6, 8, 9));
    }

    List<Integer> currList = genNum(digits - 1, N);
    List<Integer> list = new ArrayList<>();
    for (int ii = 1; ii < arr.length; ii++) {
      for (int a : currList) {
        int number = (int) Math.pow(10.0, (digits - 1)) * arr[ii] + a;
        if (number > N) return list;

        if (number != rotate(number)) ans++;
        list.add(number);
      }
    }
    currList.addAll(list);
    return currList;
  }

  public int rotate(int number) {
    int newnum = 0;
    int temp;
    while (number != 0) {
      temp = number % 10;
      if (temp == 6) temp = 9;
      else if (temp == 9) temp = 6;

      newnum = newnum * 10 + temp;
      number = number / 10;
    }
    return newnum;
  }

  public int getDigitCount(int number) {
    int count = 0;

    while (number != 0) {
      count++;
      number = number / 10;
    }
    return count;
  }
}

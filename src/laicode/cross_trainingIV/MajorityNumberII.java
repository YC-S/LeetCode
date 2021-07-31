package laicode.cross_trainingIV;

import java.util.ArrayList;
import java.util.List;

public class MajorityNumberII {
  public List<Integer> majority(int[] array) {
    if (array == null || array.length == 0) return new ArrayList<Integer>();
    List<Integer> res = new ArrayList<>();
    int number1 = array[0], number2 = array[0], count1 = 0, count2 = 0, len = array.length;
    for (int i = 0; i < len; i++) {
      if (array[i] == number1) count1++;
      else if (array[i] == number2) count2++;
      else if (count1 == 0) {
        number1 = array[i];
        count1 = 1;
      } else if (count2 == 0) {
        number2 = array[i];
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    count1 = 0;
    count2 = 0;
    for (int j : array) {
      if (j == number1) count1++;
      else if (j == number2) count2++;
    }
    if (count1 > len / 3) res.add(number1);
    if (count2 > len / 3) res.add(number2);
    return res;
  }
}

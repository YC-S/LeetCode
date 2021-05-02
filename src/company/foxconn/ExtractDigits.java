package company.foxconn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractDigits {
  public static int[] extractDigits(String[] str) {
    List<Integer> list = new ArrayList<>();
    for (String s : str) {
      s = s.replaceAll("[^-?0-9]+", " ");
      String tmp = String.join("", s.trim().split(""));
      if (!tmp.equals("")) {
        list.add(Integer.parseInt(tmp));
      }
    }
    return list.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    String[] str1 = new String[] {"abschw", "123", "asb21", "-123abs"};
    System.out.println(Arrays.toString(extractDigits(str1)));
  }
}

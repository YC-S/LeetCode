package contest.atcoder.contest211;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("H", 1);
    map.put("2B", 1);
    map.put("3B", 1);
    map.put("HR", 1);
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    String s3 = sc.nextLine();
    String s4 = sc.nextLine();
    String[] arr = new String[] {s1, s2, s3, s4};
    boolean flag = true;
    for (String s : arr) {
      if (map.containsKey(s)) {
        if (map.get(s) == 1) {
          map.put(s, 0);
        } else {
          flag = false;
          break;
        }
      } else {
        System.out.println("No");
      }
    }
    if (flag) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}

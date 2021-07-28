package contest.codechef.july_cookoff;

import java.util.*;

public class ShoeFit {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] shoes = sc.nextLine().split(" ");
      Set<String> set = new HashSet<>();
      for (String shoe : shoes) {
        set.add(shoe);
      }
      if (set.size() == 2) list.add(1);
      else list.add(0);
    }
    for (Integer integer : list) {
      System.out.println(integer);
    }
  }
}

package contest.atcoder.contest217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    String s3 = sc.nextLine();
    Set<String> set = new HashSet<>(Arrays.asList("ABC", "ARC", "AGC", "AHC"));
    set.remove(s1);
    set.remove(s2);
    set.remove(s3);
    System.out.println(set.toArray()[0]);
  }
}

package contest.atcoder.contest217;

import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      int x = arr[i];
      res[x - 1] = i + 1;
    }
    for (int i = 0; i < n; i++) {
      System.out.print(res[i] + " ");
    }
  }
}

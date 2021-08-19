package contest.online_judge;

import java.util.Scanner;

public class P100 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        if (line.equals("")) {
          System.exit(0);
          sc.close();
        }
        String[] nums = line.split(" ");
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int max = 1;
        for (int i = a; i <= b; i++) {
          int[] arr = new int[2];
          arr[0] = i;
          arr[1] = 1;
          max = Math.max(helper(arr), max);
        }
        System.out.println(a + " " + b + " " + max);
      }
    }
  }

  private static int helper(int[] arr) {
    if (arr[0] == 1) return arr[1];
    if (arr[0] % 2 == 1) {
      arr[0] = arr[0] * 3 + 1;
    } else {
      arr[0] = arr[0] / 2;
    }
    arr[1] = arr[1] + 1;
    return helper(arr);
  }
}

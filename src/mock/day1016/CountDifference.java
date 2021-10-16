package mock.day1016;

public class CountDifference {
  // 动态移动两个指针，update count 和 character。
  // Time: O(n)
  // Space: O(1)
  public static int countDifference(String s1, String s2) {
    char[] arr1 = s1.toCharArray();
    char[] arr2 = s2.toCharArray();
    int i = 0, j = 0;
    int cur1 = 0, cur2 = 0;
    int total = 0;
    char ch1 = ' ', ch2 = ' ';
    while (i < arr1.length && j < arr2.length) {
      if (cur1 == 0) {
        while (Character.isDigit(arr1[i])) {
          cur1 = cur1 * 10 + arr1[i] - '0';
          i++;
        }
        ch1 = arr1[i];
      }
      i++;
      if (cur2 == 0) {
        while (Character.isDigit(arr2[j])) {
          cur2 = cur2 * 10 + arr2[j] - '0';
          j++;
        }
        ch2 = arr2[j];
      }
      j++;
      if (ch1 == ch2) {
        if (cur1 < cur2) {
          total += cur2 - cur1;
          cur2 -= cur1;
        } else if (cur1 > cur2) {
          total += cur1 - cur2;
          cur1 -= cur2;
        } else {
          cur1 = 0;
          cur2 = 0;
        }
      } else {
        if (cur1 < cur2) {
          total += cur1;
          cur2 -= cur1;
          cur1 = 0;
        } else if (cur1 > cur2) {
          total += cur2;
          cur1 -= cur2;
          cur2 = 0;
        } else {
          total += cur1;
          cur1 = 0;
          cur2 = 0;
        }
      }
    }
    return total;
  }

  public static void main(String[] args) {
    System.out.println(countDifference("2a3b1c", "1a2b3c"));
    System.out.println(countDifference("10000a80000b10001a9c", "90000b10000a10b"));
  }
}

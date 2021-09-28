package leetcode500.p06_string.plan3;

public class P541_ReverseStringII {
  public static void main(String[] args) {
    System.out.println(new P541_ReverseStringII().reverseStr("abcd", 4));
  }

  public String reverseStr(String s, int k) {
    char[] arr = s.toCharArray();
    int n = arr.length;
    int i = 0;
    while (i < n) {
      if (i + k < n) {
        reverse(arr, i, i + k - 1);
        i += 2 * k;
      } else {
        reverse(arr, i, n - 1);
        break;
      }
    }
    return new String(arr);
  }

  private void reverse(char[] arr, int l, int r) {
    while (l <= r) {
      char tmp = arr[l];
      arr[l] = arr[r];
      arr[r] = tmp;
      l++;
      r--;
    }
  }
}

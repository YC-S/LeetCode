package leetcode500.p06_string.plan3;

public class P186_ReverseWordsInAStringII {
  public static void main(String[] args) {
    char[] s = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
    new P186_ReverseWordsInAStringII().reverseWords(s);
    System.out.println(s);
  }

  public void reverseWords(char[] s) {
    int i = 0, j = 0;
    while (j < s.length) {
      if (s[j] == ' ') {
        reverse(s, i, j - 1);
        i = j + 1;
        j = i;
      } else {
        j++;
      }
    }
    reverse(s, i, s.length - 1);
    reverse(s, 0, s.length - 1);
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

package leetcode500.p06_string.plan3;

public class P345_ReverseVowelsOfAString {
  public static void main(String[] args) {
    System.out.println(new P345_ReverseVowelsOfAString().reverseVowels(".,"));
  }

  public String reverseVowels(String s) {
    char[] arr = s.toCharArray();
    int i = 0, j = arr.length - 1;
    while (i < j) {
      while (i < arr.length && !"aeiouAEIOU".contains(String.valueOf(arr[i]))) {
        i++;
      }
      while (j >= 0 && !"aeiouAEIOU".contains(String.valueOf(arr[j]))) {
        j--;
      }
      if (i < j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      }
      i++;
      j--;
    }
    return new String(arr);
  }
}

package leetcode500.p06_string.plan3;

public class P557_ReverseWordsInAStringIII {
  public String reverseWords(String s) {
    String[] words = s.split(" +");
    for (int i = 0; i < words.length; i++) {
      words[i] = reverse(words[i]);
    }
    return String.join(" ", words);
  }

  private String reverse(String word) {
    char[] arr = word.toCharArray();
    int i = 0, j = arr.length - 1;
    while (i <= j) {
      char tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
      i++;
      j--;
    }
    return new String(arr);
  }
}

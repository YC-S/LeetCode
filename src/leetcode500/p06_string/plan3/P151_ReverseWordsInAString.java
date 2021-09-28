package leetcode500.p06_string.plan3;

public class P151_ReverseWordsInAString {
  public static void main(String[] args) {
    System.out.println(new P151_ReverseWordsInAString().reverseWords("a good    example"));
  }

  public String reverseWords(String s) {
    s = s.trim().replaceAll(" +", " ");
    String[] words = s.split(" ");
    for (int i = 0; i < words.length; i++) {
      words[i] = reverse(words[i]);
    }

    String res = String.join(" ", words);
    return reverse(res);
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

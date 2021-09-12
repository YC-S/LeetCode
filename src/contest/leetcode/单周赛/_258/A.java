package contest.leetcode.单周赛._258;

public class A {
  public static void main(String[] args) {
    System.out.println(new A().reversePrefix("abcdefd", 'd'));
    System.out.println(new A().reversePrefix("xyxzxe", 'z'));
    System.out.println(new A().reversePrefix("abcd", 'z'));
  }

  public String reversePrefix(String word, char ch) {

    int index = word.indexOf(ch);
    if (index == -1) {
      return word;
    }
    String first = reverse(word.substring(0, index + 1));
    String second = word.substring(index + 1);
    return first + second;
  }

  private String reverse(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }
}

package book.laioffer;

public class P649_StringReplace {
  public static String replace(String input, String source, String target) {
    StringBuilder sb = new StringBuilder();
    int startIndex = 0;
    int matchIndex = input.indexOf(input, startIndex);
    while (matchIndex != -1) {
      sb.append(input, startIndex, matchIndex).append(target);
      startIndex = matchIndex + source.length();
      matchIndex = input.indexOf(source, startIndex);
    }
    sb.append(input.substring(startIndex));
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(replace("appledogapple", "apple", "cat"));
  }
}

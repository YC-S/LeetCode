package book.laioffer;

public class P175_DecompressStringII {
  public static String decompress(String input) {
    if (input.length() == 0) return input;
    StringBuilder sb = new StringBuilder();
    int count = 0;
    char character = input.charAt(0);
    for (int i = 0; i < input.length(); i++) {
      char tmp = input.charAt(i);
      if (Character.isDigit(tmp)) {
        count = count * 10 + tmp - '0';
      } else {
        while (count > 0) {
          sb.append(character);
          count--;
        }
        character = tmp;
      }
    }
    while (count > 0) {
      sb.append(character);
      count--;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    //    System.out.println(decompress("1a0c2b4c"));
    System.out.println(decompress("a1c0b2c4"));
  }
}

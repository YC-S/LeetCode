package book.laioffer;

public class P78_HexadecimalRepresentation {
  public static String hex(int number) {
    if (number == 0) return "0x0";
    StringBuilder sb = new StringBuilder();
    char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    while (number != 0) {
      sb.append(array[number % 16]);
      number /= 16;
    }
    sb.append("x0");
    sb.reverse();
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(hex(1));
  }
}

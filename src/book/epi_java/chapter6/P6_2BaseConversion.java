package book.epi_java.chapter6;

public class P6_2BaseConversion {
  public static String convertBase(String numAsString, int b1, int b2) {
    boolean isNegative = numAsString.startsWith("-");
    int numAsInt =
        numAsString
            .substring(isNegative ? 1 : 0)
            .chars()
            .reduce(0, (x, c) -> x * b1 + (Character.isDigit(c) ? c - '0' : c - 'A' + 10));
    return (isNegative ? "-" : "") + (numAsInt == 0 ? "0" : constructFromBase(numAsInt, b2));
  }

  private static String constructFromBase(int numAsInt, int base) {
    return numAsInt == 0
        ? ""
        : constructFromBase(numAsInt / base, base)
            + (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10 : '0' + numAsInt % base);
  }
}

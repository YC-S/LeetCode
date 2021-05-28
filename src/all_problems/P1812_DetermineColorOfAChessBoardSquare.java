package all_problems;

public class P1812_DetermineColorOfAChessBoardSquare {
  public boolean squareIsWhite(String a) {
    return (int) a.charAt(0) % 2 != (int) a.charAt(1) % 2;
  }
}

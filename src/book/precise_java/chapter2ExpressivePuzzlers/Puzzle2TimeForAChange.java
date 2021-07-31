package book.precise_java.chapter2ExpressivePuzzlers;

import java.math.BigDecimal;

public class Puzzle2TimeForAChange {
  public static void main(String[] args) {
    System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
  }
}

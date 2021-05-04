package interview.year2020;

import java.time.LocalDate;

public class Q1 {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2012, 2, 29);
    date.plusYears(2);
    System.out.println(date);
  }
}

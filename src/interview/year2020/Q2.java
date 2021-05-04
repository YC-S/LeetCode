package interview.year2020;

import java.text.DateFormat;
import java.util.Date;

public class Q2 {
  public static void main(String[] args) {
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
    String formatedDate = dateFormat.format(date);
    System.out.println(formatedDate);
  }
}

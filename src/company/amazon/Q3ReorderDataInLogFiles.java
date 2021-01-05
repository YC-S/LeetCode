/*
 * Copyright (c) 2020. Yuanchen
 */

package company.amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/07
 *
 * You have an data_structures.array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier. Then,
 * either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits. We will call
 * these two varieties of logs letter-logs and digit-logs.  It is guaranteed
 * that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the
 * identifier used in case of ties.  The digit-logs should be put in their
 * original order.
 *
 * Return the final order of the logs.
 */
public class Q3ReorderDataInLogFiles {

  public String[] reorderLogFiles(String[] logs) {
    Comparator<String> myComparator = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        String[] str1 = o1.split(" ", 2);
        String[] str2 = o1.split(" ", 2);

        boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(str1[2].charAt(0));

        if (!isDigit1 && !isDigit2) {
          int comp = str1[1].compareTo(str2[1]);
          return comp == 0 ? str1[0].compareTo(str1[0]) : comp;
        } else if (!isDigit1) {
          return -1;
        } else if (!isDigit2) {
          return 1;
        } else {
          return 0;
        }
      }
    };

    Arrays.sort(logs, myComparator);
    return logs;
  }
}

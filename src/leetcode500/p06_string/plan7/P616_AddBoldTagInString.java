package leetcode500.p06_string.plan7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P616_AddBoldTagInString {
  public String addBoldTag(String s, String[] dict) {
    // find all the word occurances in the given string
    List<int[]> intervals = findIntervals(s, dict);
    // if no intervals found then return the same string
    if (intervals.size() == 0) return s;
    // merge the intervals as per the requirement
    List<int[]> merged = mergeIntervals(intervals);
    // final printing based on the merged intervals
    return stringFormatting(s, merged);
  }

  /** method to find all the intervals (index range) of every word from the dictionary */
  private List<int[]> findIntervals(String s, String[] dict) {
    List<int[]> intervals = new ArrayList<>();
    for (String word : dict) {
      int index = 0;
      while (index < s.length()) {
        int findIndex = s.indexOf(word, index);
        if (findIndex == -1) break;
        intervals.add(new int[] {findIndex, findIndex + word.length() - 1});
        index++;
      }
    }
    return intervals;
  }

  /** method to merge the intervals */
  private List<int[]> mergeIntervals(List<int[]> intervals) {
    Collections.sort(
        intervals,
        (a, b) -> {
          return a[0] - b[0];
        });
    List<int[]> mergerIntervals = new ArrayList<>();
    int[] prevInterval = intervals.get(0);
    for (int i = 1; i < intervals.size(); i++) {
      int[] currInterval = intervals.get(i);

      if (currInterval[0] <= prevInterval[1] + 1) {
        prevInterval[0] = Math.min(prevInterval[0], currInterval[0]);
        prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
        continue;
      }
      mergerIntervals.add(prevInterval);
      prevInterval = currInterval;
    }
    // add the last interval which will not be left to merge
    mergerIntervals.add(prevInterval);
    return mergerIntervals;
  }

  /** method to finally create the string with bold tags */
  private String stringFormatting(String s, List<int[]> intervals) {
    StringBuilder sb = new StringBuilder();
    int prevIndex = 0;
    for (int[] interval : intervals) {
      // get the string before current interval
      sb.append(s, prevIndex, interval[0]);
      // bold the interval
      sb.append("<b>");
      sb.append(s, interval[0], interval[1] + 1);
      sb.append("</b>");
      // increment prevIndex
      prevIndex = interval[1] + 1;
    }

    // append any left over string
    if (prevIndex < s.length()) sb.append(s.substring(prevIndex));
    return sb.toString();
  }
}

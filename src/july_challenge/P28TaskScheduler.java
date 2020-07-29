/*
 * Copyright (c) 2020. Yuanchen
 */

package july_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/28
 */
public class P28TaskScheduler {

  public int leastInterval(char[] tasks, int n) {
    int[] frequencies = new int[26];
    for (int t : tasks) {
      frequencies[t - 'A']++;
    }

    // max frequency
    int f_max = 0;
    for (int f : frequencies) {
      f_max = Math.max(f_max, f);
    }

    // count the most frequent tasks
    int n_max = 0;
    for (int f : frequencies) {
      if (f == f_max) {
        n_max++;
      }
    }

    return Math.max(tasks.length, (f_max - 1) * (n + 1) + n_max);
  }
}

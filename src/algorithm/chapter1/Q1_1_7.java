/*
 * Copyright (c) 2020. Yuanchen
 */

package algorithm.chapter1;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/20
 */
public class Q1_1_7 {

  public static void main(String[] args) {
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) {
      t = (9.0 / t + t) / 2.0;
    }
    System.out.printf("%.5f\n", t);

    int sum = 0;
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    System.out.println(sum);

    sum = 0;
    for (int i = 1; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        sum++;
      }
    }
    System.out.println(sum);
  }

}

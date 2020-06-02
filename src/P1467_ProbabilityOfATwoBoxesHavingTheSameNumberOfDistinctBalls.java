/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/02
 */
public class P1467_ProbabilityOfATwoBoxesHavingTheSameNumberOfDistinctBalls {

  public double getProbability(int[] balls) {
    int sum = 0;
    for (int i = 0; i < balls.length; ++i) {
      sum += balls[i];
    }
    //Get all possible cases where we select same number of balls in both bins
    double all = allCases(balls, 0, 0, 0, 0, 0, sum);
    //Get all possible cases where we select same number of balls in both bins + we select same number of distinct balls
    double valid = casesWithEqualDistinctBalls(balls, 0, 0, 0, 0, 0, sum);

    return ((1.0) * valid / all);
  }

  /**
   * disF = distinct balls in first bin disS = distinct balls in second bin f =
   * number of balls in first bin s = number of balls in second bin
   */
  public double allCases(int[] b, int pos, int f, int s, int disF, int disS,
    int sum) {
    if (pos == b.length) {
      // for all cases, we just need to check if both bins have same number of balls or not
      if (f == s) {
        //numerator of our permutations
        return fact(sum / 2) * fact(sum / 2);
      }
      return 0;
    }
    // we put all balls in second bin
    double answer =
      1.0 * allCases(b, pos + 1, f, s + b[pos], disF, disS + 1, sum) / fact(
        b[pos]);

    // we put all balls in first bin
    answer +=
      1.0 * allCases(b, pos + 1, f + b[pos], s, disF + 1, disS, sum) / fact(
        b[pos]);
    for (int i = 1; i < b[pos]; ++i) {
      answer += 1.0 * (
        allCases(b, pos + 1, f + i, s + b[pos] - i, disF + 1, disS + 1, sum) / (
          fact(i) * fact(b[pos]
            - i))); // We put i ball in bin and b[pos] - i in another, now since all of them are of same color, we need to divide permutation by  (fact(i) * fact(b[pos]-i)), this acts as a denominator of our permutations
    }
    return answer;

  }

  /**
   * disF = distinct balls in first bin disS = distinct balls in second bin f =
   * number of balls in first bin s = number of balls in second bin
   */
  public double casesWithEqualDistinctBalls(int[] b, int pos, int f, int s,
    int disF, int disS, int sum) {
    if (pos == b.length) {
      // we  need to check if both bins have same number of balls or not + number of distinct balls in each bin should be equal
      if (f == s && disF == disS) {
        //numerator of our permutations
        return fact(sum / 2) * fact(sum / 2);
      }
      return 0;
    }

    // we put all balls in second bin
    double answer =
      1.0 * casesWithEqualDistinctBalls(b, pos + 1, f, s + b[pos], disF,
        disS + 1, sum) / fact(b[pos]);

    // we put all balls in first bin
    answer +=
      1.0 * casesWithEqualDistinctBalls(b, pos + 1, f + b[pos], s, disF + 1,
        disS, sum) / fact(b[pos]);
    // We put i ball in bin and b[pos] - i in another, now since all of them are of same color, we need to divide permutation by  (fact(i) * fact(b[pos]-i)), this acts as a denominator of our permutations
    for (int i = 1; i < b[pos]; ++i) {
      answer += 1.0 * (
        casesWithEqualDistinctBalls(b, pos + 1, f + i, s + b[pos] - i, disF + 1,
          disS + 1, sum) / (fact(i) * fact(b[pos]
          - i)));
    }
    return answer;

  }

  double fact(double n) {
    double res = 1;
    for (int i = 2; i <= n; i++) {
      res = res * i;
    }
    return res;
  }

}

/*
 * Copyright (c) 2020. Yuanchen
 */

package july_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/14
 */
public class P14AngleBetweenHandsOfAClock {

  public double angleClock(int hour, int minutes) {
    int oneMinAngle = 6;
    int oneHourAngle = 30;

    double minutesAngle = oneMinAngle * minutes;
    double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

    double diff = Math.abs(hourAngle - minutesAngle);
    return Math.min(diff, 360 - diff);
  }
}

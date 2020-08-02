/*
 * Copyright (c) 2020. Yuanchen
 */

package august_challenge;

import java.util.HashMap;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/01
 */
public class P1LoggerRateLimiter {

  private final HashMap<String, Integer> msgDict;

  /**
   * Initialize your data structure here.
   */
  public P1LoggerRateLimiter() {
    msgDict = new HashMap<String, Integer>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp,
   * otherwise returns false.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {

    if (!this.msgDict.containsKey(message)) {
      this.msgDict.put(message, timestamp);
      return true;
    }

    Integer oldTimestamp = this.msgDict.get(message);
    if (timestamp - oldTimestamp >= 10) {
      this.msgDict.put(message, timestamp);
      return true;
    } else {
      return false;
    }
  }
}

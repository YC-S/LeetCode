package leetcode500.P14_hybrid_data_structure.plan2;

import java.util.HashMap;

public class P359_LoggerRateLimiter {
  private HashMap<String, Integer> msgDict;

  /** Initialize your data structure here. */
  public P359_LoggerRateLimiter() {
    msgDict = new HashMap<String, Integer>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
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
    } else return false;
  }
}

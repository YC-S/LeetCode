package laicode.cross_trainingIV;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInStream {
  Map<Character, Integer> map = new HashMap<>();
  Deque<Character> deque = new ArrayDeque<>();

  public FirstNonRepeatingCharacterInStream() {}

  public void read(char ch) {
    Integer count = map.get(ch);
    if (count != null) {
      map.put(ch, count + 1);
      while (!deque.isEmpty() && map.get(deque.peekFirst()) > 1) deque.pollFirst();
    } else {
      map.put(ch, 1);
      deque.offerLast(ch);
    }
  }

  public Character firstNonRepeating() {
    return deque.isEmpty() ? null : deque.peekFirst();
  }
}

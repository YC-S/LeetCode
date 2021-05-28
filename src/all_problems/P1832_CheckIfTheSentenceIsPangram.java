package all_problems;

import java.util.HashSet;
import java.util.Set;

public class P1832_CheckIfTheSentenceIsPangram {
  public boolean checkIfPangram(String sentence) {
    Set<Character> s = new HashSet<>();
    for (int i = 0; i < sentence.length(); ++i) s.add(sentence.charAt(i));
    return s.size() == 26;
  }
}

package triplebyte.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F {
  public static void main(String[] args) {
    List<String> words = new ArrayList<>(Arrays.asList("Hello", "World"));
    for (int i = 0; i < words.size(); i++) {
      String word = new StringBuilder(words.get(i)).reverse().toString();
      word.toLowerCase();
      words.set(i, word);
    }
    System.out.println(words);
  }
}

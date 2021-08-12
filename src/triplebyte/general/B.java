package triplebyte.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Tree extends HashMap<String, Tree> {}

public class B {
  public static Tree build(List<String> sentenceList) {
    Tree root = new Tree();
    for (String sentence : sentenceList) {
      Tree base = root;
      for (String word : sentence.split(" ")) {
        if (!base.containsKey(word)) base.put(word, new Tree());
        base = base.get(word);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    Tree tree = build(Arrays.asList("Hello world", "Hello there"));
    System.out.println(tree);
  }
}

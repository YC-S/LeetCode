package algoexpert;

import java.util.ArrayList;

public class GenerateDivTags {
  public ArrayList<String> generateDivTags(int numberOfTags) {
    // Write your code here.
    ArrayList<String> matchedDivTags = new ArrayList<>();
    generateDivTagsFromPrefix(numberOfTags, numberOfTags, "", matchedDivTags);
    return matchedDivTags;
  }

  public void generateDivTagsFromPrefix(
      int openingTagsNeeded, int closingTagsNeeded, String prefix, ArrayList<String> result) {
    if (openingTagsNeeded > 0) {
      String newPrefix = prefix + "<div>";
      generateDivTagsFromPrefix(openingTagsNeeded - 1, closingTagsNeeded, newPrefix, result);
    }
    if (openingTagsNeeded < closingTagsNeeded) {
      String newPrefix = prefix + "</div>";
      generateDivTagsFromPrefix(openingTagsNeeded, closingTagsNeeded - 1, newPrefix, result);
    }
    if (closingTagsNeeded == 0) {
      result.add(prefix);
    }
  }
}

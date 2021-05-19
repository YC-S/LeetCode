package algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumCharactersForWoods {
  public char[] minimumCharactersForWords(String[] words) {
    HashMap<Character, Integer> maximumCharacterFrequencies = new HashMap<>();
    for (String word : words) {
      HashMap<Character, Integer> characterFrequencies = countCharacterFrequencies(word);
      updateMaximumFrequencies(characterFrequencies, maximumCharacterFrequencies);
    }
    return makeArrayFromCharacterFrequencies(maximumCharacterFrequencies);
  }

  public HashMap<Character, Integer> countCharacterFrequencies(String string) {
    HashMap<Character, Integer> characterFrequencies = new HashMap<>();
    for (char character : string.toCharArray()) {
      characterFrequencies.put(character, characterFrequencies.getOrDefault(character, 0) + 1);
    }
    return characterFrequencies;
  }

  public void updateMaximumFrequencies(
      HashMap<Character, Integer> frequencies, HashMap<Character, Integer> maximumFrequencies) {
    for (Map.Entry<Character, Integer> frequency : frequencies.entrySet()) {
      char character = frequency.getKey();
      int characterFrequency = frequency.getValue();

      if (maximumFrequencies.containsKey(character)) {
        maximumFrequencies.put(
            character, Math.max(characterFrequency, maximumFrequencies.get(character)));
      } else {
        maximumFrequencies.put(character, characterFrequency);
      }
    }
  }

  public char[] makeArrayFromCharacterFrequencies(
      HashMap<Character, Integer> characterFrequencies) {
    ArrayList<Character> characters = new ArrayList<>();
    for (Map.Entry<Character, Integer> frequency : characterFrequencies.entrySet()) {
      char character = frequency.getKey();
      int characterFrequency = frequency.getValue();

      for (int idx = 0; idx < characterFrequency; idx++) {
        characters.add(character);
      }
    }

    char[] charactersArray = new char[characters.size()];
    for (int idx = 0; idx < characters.size(); idx++) {
      charactersArray[idx] = characters.get(idx);
    }

    return charactersArray;
  }
}

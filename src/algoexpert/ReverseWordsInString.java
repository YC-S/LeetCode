package algoexpert;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();
        System.out.println(solution.reverseWordsInString("abc bcd def"));
    }

    public String reverseWordsInString(String string) {
        ArrayList<String> words = new ArrayList<>();
        int startOfWord = 0;

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character == ' ') {
                words.add(string.substring(startOfWord, i));
                startOfWord = i;
            } else if (string.charAt(startOfWord) == ' ') {
                words.add(" ");
                startOfWord = i;
            }
        }

        words.add(string.substring(startOfWord));
        Collections.reverse(words);
        return String.join("", words);
    }
}

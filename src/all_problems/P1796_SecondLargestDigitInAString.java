package all_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P1796_SecondLargestDigitInAString {
    public static void main(String[] args) {
        System.out.println(new P1796_SecondLargestDigitInAString().secondHighest("dfa12321afd"));
        System.out.println(new P1796_SecondLargestDigitInAString().secondHighest("abc1111"));
    }

    public int secondHighest(String s) {
        char[] arr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : arr) {
            if (Character.isDigit(c)) {
                list.add((char) (c - '0'));
            }
        }
        if (list.size() == 0) {
            return -1;
        }
        Collections.sort(list, Comparator.reverseOrder());
        int largest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != largest) {
                return Integer.valueOf(list.get(i));
            }
        }
        return -1;
    }
}

package company.wepay;

public class ValidAnagram {
    /**
     * First increment the counter for s, then decrement the counter for t. If at any point the counter drops below zero, we know that t contains an extra letter not in s and return false immediately.
     **/
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            array[t.charAt(i) - 'a']--;
            if (array[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
/**
 * Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * Answer: Use a hash table instead of a fixed size counter. Imagine allocating a large size array to fit the entire range of unicode characters, which could go up to more than 1 million. A hash table is a more generic solution and could adapt to any range of characters.
 **/


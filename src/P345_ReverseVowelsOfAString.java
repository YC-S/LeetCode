

public class P345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        int i = 0, j = s.length() - 1;
        char[] array = s.toCharArray();
        while (i <= j) {
            if (vowels.indexOf(array[i]) != -1 && vowels.indexOf(array[j]) != -1) {
                char tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            } else if (vowels.indexOf(array[i]) != -1) {
                j--;
            } else if (vowels.indexOf(array[j]) != -1) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(array);
    }
}

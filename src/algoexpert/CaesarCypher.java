package algoexpert;

public class CaesarCypher {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            key %= 26;
            if (cur + key <= 'z') {
                cur += key;
            } else {
                cur = (char) (cur + key - 26);
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}

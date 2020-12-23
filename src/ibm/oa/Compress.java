package ibm.oa;

public class Compress {
    public static void main(String[] args) {
        Compress solution = new Compress();
        System.out.println(solution.compressedString("abbccc"));
    }

    public String compressedString(String message) {
        char[] chars = message.toCharArray();
        StringBuilder sb = new StringBuilder();
        int anchor = 0, write = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == chars.length || chars[i + 1] != chars[i]) {
                sb.append(chars[anchor]);
                chars[write++] = chars[anchor];
                if (i > anchor) {
                    for (char c : ("" + (i - anchor + 1)).toCharArray()) {
                        sb.append(c);
                        chars[write++] = c;
                    }
                }
                anchor = i + 1;
            }
        }
        return sb.toString();
    }
}

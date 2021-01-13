package all_problems;

public class P604_DesignCompressedStringIterator {
    String compressedString;
    Character cur;
    int count;
    int i;

    public P604_DesignCompressedStringIterator(String compressedString) {
        this.compressedString = compressedString;
        this.cur = null;
        this.i = 0;
        this.count = 0;
    }

    public char next() {
        if (count == 0) {
            if (i >= compressedString.length()) {
                return ' ';
            }
            cur = compressedString.charAt(i++);
            while (i < compressedString.length() && compressedString.charAt(i) >= '0' && compressedString.charAt(i) <= '9') {
                count = 10 * count + (compressedString.charAt(i) - '0');
                i++;
            }
        }
        count--;
        return cur;
    }

    public boolean hasNext() {
        return i < compressedString.length() || count != 0;
    }
}

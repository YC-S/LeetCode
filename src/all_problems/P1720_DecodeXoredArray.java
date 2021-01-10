package all_problems;

import java.util.Arrays;

public class P1720_DecodeXoredArray {
    public static int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        int index = 0;
        res[index++] = first;
        while (index < res.length) {
            res[index] = encoded[index - 1] ^ first;
            first = res[index];
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] encoded = {6, 2, 7, 3};
        System.out.println(Arrays.toString(decode(encoded, 4)));
    }
}

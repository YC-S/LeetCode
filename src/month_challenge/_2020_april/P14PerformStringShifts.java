package month_challenge._2020_april;

/**
 * @author shiyuanchen
 */
public class P14PerformStringShifts {
    public static String stringShift(String s, int[][] shift) {
        int rightShift = 0;
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                rightShift -= shift[i][1];
            } else {
                rightShift += shift[i][1];
            }
        }
        rightShift %= s.length();
        if (rightShift > 0) {
            return rotateRight(arr, rightShift, sb);
        } else if (rightShift < 0) {
            return rotateLeft(arr, -rightShift, sb);
        } else {
            return s;
        }
    }

    private static String rotateRight(char[] arr, int shift, StringBuilder sb) {
        for (int i = arr.length - shift; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        for (int i = 0; i < arr.length - shift; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private static String rotateLeft(char[] arr, int shift, StringBuilder sb) {
        for (int i = shift; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        for (int i = 0; i < shift; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abc";
        String s1 = "abcdefg";
        String s2 = "wpdhhcj";
        int[][] shift = {{0, 1}, {1, 2}};
        int[][] shift1 = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        int[][] shift2 = {{0, 7}, {1, 7}, {1, 0}, {1, 3}, {0, 3}, {0, 6}, {1, 2}};
        System.out.println(stringShift(s, shift));
        System.out.println(stringShift(s1, shift1));
        System.out.println(stringShift(s2, shift2));
    }
}

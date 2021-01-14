package all_problems;

public class P738_MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] array = String.valueOf(N).toCharArray();

        int monotoneIncreasingEnd = array.length - 1;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                monotoneIncreasingEnd = i - 1;
                array[i - 1]--;
            }
        }
        for (int i = monotoneIncreasingEnd + 1; i < array.length; i++) {
            array[i] = '9';
        }
        return Integer.parseInt(new String(array));
    }
}

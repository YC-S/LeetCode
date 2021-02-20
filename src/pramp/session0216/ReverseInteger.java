package pramp.session0216;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE)); //-321
    }

    public static int reverse(long x) {
        int result = 0;
        if (x > Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return result;
        }
        while (x != 0) {
            int pop = (int) x % 10; // -2
            x /= 10; // -1
            result = result * 10 + pop; // -32
        }
        return result;
    }
}

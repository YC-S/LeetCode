package all_problems;

public class P343_IntegerBreak {
    public static int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int count3 = n / 3;
        int left = n % 3;
        if (left == 1) {
            count3 -= 1;
            left = 4;
        }
        return left != 0 ? (int) (Math.pow(3, count3)) * left : (int) (Math.pow(3, count3));
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
